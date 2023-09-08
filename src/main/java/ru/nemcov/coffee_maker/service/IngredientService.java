package ru.nemcov.coffee_maker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nemcov.coffee_maker.entity.Ingredient;
import ru.nemcov.coffee_maker.repo.IngredientRepo;

@Service
public class IngredientService {

    private final IngredientRepo ingredientRepo;

    public IngredientService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public List<Ingredient> findAll() {
        return ingredientRepo.findAll();
    }

    public Ingredient findById(Long id) {
        return ingredientRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Ingredient doesn't exist"));
    }

    public void reduceIngredient(Long ingredientId, Integer quantityRequired) {
        Ingredient ingredient = findById(ingredientId);

        ingredient.setQuantity(ingredient.getQuantity() - quantityRequired);
        ingredientRepo.save(ingredient);
    }

    public boolean checkQuantity(Long ingredientId, Integer quantityRequired) {
        return findById(ingredientId).getQuantity() >= quantityRequired;
    }

    @Transactional
    public Ingredient updateIngredient(Ingredient ingredient) {
        Ingredient dbIngredient = findById(ingredient.getIngredientId());
        dbIngredient.setQuantity(dbIngredient.getQuantity() + ingredient.getQuantity());

        return ingredientRepo.save(dbIngredient);
    }
}
