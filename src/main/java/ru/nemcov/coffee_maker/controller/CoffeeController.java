package ru.nemcov.coffee_maker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.service.CoffeeService;

@RestController
@Tag(name = "Основное меню")
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Operation(
            description = "Получить список кофе",
            summary = "Список кофе"
    )
    @GetMapping
    public ResponseEntity<List<Coffee>> findAll() {
        return ResponseEntity.ok(coffeeService.findAll());
    }

    @Operation(
            description = "Получить кофе",
            summary = "Статус вида кофе"
    )
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(coffeeService.findById(id));
    }

    @Operation(
            description = "Заказать кофе",
            summary = "Заказ кофе"
    )
    @GetMapping("/order/{id}")
    public ResponseEntity orderCoffee(@PathVariable Long id) {
        return ResponseEntity.ok(coffeeService.orderCoffee(id));
    }
}
