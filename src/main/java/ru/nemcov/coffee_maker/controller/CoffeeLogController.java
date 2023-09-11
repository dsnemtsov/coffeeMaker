package ru.nemcov.coffee_maker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemcov.coffee_maker.entity.CoffeeLog;
import ru.nemcov.coffee_maker.service.CoffeeLogService;

@RestController
@Tag(name = "История заказов")
@RequestMapping("/coffee/log")
public class CoffeeLogController {

    private final CoffeeLogService coffeeLogService;

    public CoffeeLogController(CoffeeLogService coffeeLogService) {
        this.coffeeLogService = coffeeLogService;
    }

    @Operation(
            description = "Получить историю заказов",
            summary = "История заказов"
    )
    @GetMapping
    public ResponseEntity<List<CoffeeLog>> findAll() {
        return ResponseEntity.ok(coffeeLogService.findAll());
    }
}
