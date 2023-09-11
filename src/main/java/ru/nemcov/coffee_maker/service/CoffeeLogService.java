package ru.nemcov.coffee_maker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nemcov.coffee_maker.entity.CoffeeLog;
import ru.nemcov.coffee_maker.repo.CoffeeLogRepo;

@Service
public class CoffeeLogService {

    private final CoffeeLogRepo coffeeLogRepo;

    public CoffeeLogService(CoffeeLogRepo coffeeLogRepo) {
        this.coffeeLogRepo = coffeeLogRepo;
    }

    public List<CoffeeLog> findAll() {
        return coffeeLogRepo.findAll();
    }
}
