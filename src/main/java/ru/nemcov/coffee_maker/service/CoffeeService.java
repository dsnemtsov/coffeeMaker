package ru.nemcov.coffee_maker.service;

import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.entity.CoffeeLog;
import ru.nemcov.coffee_maker.entity.Consumable;
import ru.nemcov.coffee_maker.repo.CoffeeLogRepo;
import ru.nemcov.coffee_maker.repo.CoffeeRepo;

@Service
public class CoffeeService {

    private final CoffeeRepo coffeeRepo;
    private final ConsumableService consumableService;
    private final IngredientService ingredientService;
    private final CoffeeLogRepo coffeeLogRepo;

    public CoffeeService(CoffeeRepo coffeeRepo, ConsumableService consumableService, IngredientService ingredientService, CoffeeLogRepo coffeeLogRepo) {
        this.coffeeRepo = coffeeRepo;
        this.consumableService = consumableService;
        this.ingredientService = ingredientService;
        this.coffeeLogRepo = coffeeLogRepo;
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

        coffeeLogRepo.save(CoffeeLog
                .builder()
                .coffeeId(coffee.getCoffeeId())
                .createDate(Instant.now())
                .build());

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
            coffee.setAvailable(true);
        }

        coffeeRepo.save(coffee);
    }
}
