package ru.nemcov.coffee_maker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.entity.Consumable;
import ru.nemcov.coffee_maker.repo.CoffeeRepo;

@Service
public class CoffeeService {

    private final CoffeeRepo coffeeRepo;
    private final ConsumableService consumableService;
    private final IngredientService ingredientService;

    public CoffeeService(CoffeeRepo coffeeRepo, ConsumableService consumableService, IngredientService ingredientService) {
        this.coffeeRepo = coffeeRepo;
        this.consumableService = consumableService;
        this.ingredientService = ingredientService;
    }

    public List<Coffee> findAll() {
        return coffeeRepo.findAll();
    }

    public Coffee findById(Long id) {
        return coffeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Coffee doesn't exist"));
    }

    public Coffee orderCoffee(Long id) {
        Coffee coffee = findById(id);

        if (!coffee.isAvailable()) {
            throw new IllegalStateException("Coffee is not available");
        }

        List<Consumable> consumables = consumableService.findByCoffeeId(id);

        consumables.forEach(c -> ingredientService.reduceIngredient(c.getIngredientId(), c.getQuantityRequired()));

        updateList();

        return coffee;
    }

    public void updateList() {
        List<Coffee> coffees = findAll();
        coffees.forEach(this::updateAvailable);
    }

    private void updateAvailable(Coffee coffee) {
        List<Consumable> consumables = consumableService.findByCoffeeId(coffee.getCoffeeId());

        for (Consumable consumable : consumables) {
            if (!ingredientService.checkQuantity(consumable.getIngredientId(), consumable.getQuantityRequired())) {
                coffee.setAvailable(false);
                break;
            }
        }

        coffeeRepo.save(coffee);
    }
}
