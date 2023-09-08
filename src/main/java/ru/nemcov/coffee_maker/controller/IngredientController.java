package ru.nemcov.coffee_maker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemcov.coffee_maker.entity.Ingredient;
import ru.nemcov.coffee_maker.service.IngredientService;

@RestController
@Tag(name = "Запасы ингредиентов")
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(
            description = "Получить запасы ингредиентов",
            summary = "Запасы ингредиентов"
    )
    @GetMapping
    public ResponseEntity<List<Ingredient>> findAll() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @Operation(
            description = "Пополнить запасы ингредиента",
            summary = "Пополнение ингредиента"
    )
    @PatchMapping
    public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientService.updateIngredient(ingredient));
    }
}
