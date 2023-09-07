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

    public List<Coffee> getAll() {
        return coffeeRepo.findAll();
    }
}
