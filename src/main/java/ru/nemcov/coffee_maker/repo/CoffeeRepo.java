package ru.nemcov.coffee_maker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nemcov.coffee_maker.entity.Coffee;

@Repository
public interface CoffeeRepo extends JpaRepository<Coffee, Long> {
}
