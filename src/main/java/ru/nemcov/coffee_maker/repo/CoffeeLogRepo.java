package ru.nemcov.coffee_maker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nemcov.coffee_maker.entity.CoffeeLog;

@Repository
public interface CoffeeLogRepo extends JpaRepository<CoffeeLog, Long> {
}
