package ru.nemcov.coffee_maker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nemcov.coffee_maker.entity.Consumable;
import ru.nemcov.coffee_maker.repo.ConsumableRepo;

@Service
public class ConsumableService {

    private final ConsumableRepo consumableRepo;

    public ConsumableService(ConsumableRepo consumableRepo) {
        this.consumableRepo = consumableRepo;
    }

    public List<Consumable> findByCoffeeId(Long id) {
        return consumableRepo.findByCoffeeId(id);
    }
}
