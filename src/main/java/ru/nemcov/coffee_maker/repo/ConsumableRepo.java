package ru.nemcov.coffee_maker.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nemcov.coffee_maker.entity.Consumable;

@Repository
public interface ConsumableRepo extends JpaRepository<Consumable, Long> {

    List<Consumable> findByCoffeeId(Long id);
}
