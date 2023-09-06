package ru.nemcov.coffee_maker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.service.CoffeeService;

@RestController
@Tag(name = "Основное меню")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Operation(
            description = "Получить список напитков",
            summary = "Список напитков"
    )
    @GetMapping
    public ResponseEntity<List<Coffee>> getAll() {
        return ResponseEntity.ok(coffeeService.getAll());
    }
}
