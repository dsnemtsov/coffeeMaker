package ru.nemcov.coffee_maker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.repo.CoffeeRepo;

@Service
public class CoffeeService {

    private final CoffeeRepo coffeeRepo;

    public CoffeeService(CoffeeRepo coffeeRepo) {
        this.coffeeRepo = coffeeRepo;
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
            throw   new IllegalStateException("Coffee is not available");
        }

        return coffee;
    }
}
