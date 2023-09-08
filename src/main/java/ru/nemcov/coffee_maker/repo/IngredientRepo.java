package ru.nemcov.coffee_maker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nemcov.coffee_maker.entity.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
