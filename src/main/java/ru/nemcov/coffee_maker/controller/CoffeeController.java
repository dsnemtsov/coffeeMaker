package ru.nemcov.coffee_maker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemcov.coffee_maker.entity.Coffee;

@RestController
@Tag(name = "Основное меню")
public class CoffeeController {

    @Operation(
            description = "Получить список напитков",
            summary = "Список напитков"
    )
    @GetMapping
    public ResponseEntity<List<Coffee>> getAll() {
        List<Coffee> coffee = List.of(
                Coffee.builder().coffeeId(1L).name("Эспрессо").build(),
                Coffee.builder().coffeeId(2L).name("Американо").build(),
                Coffee.builder().coffeeId(3L).name("Каппучино").build(),
                Coffee.builder().coffeeId(4L).name("Мокко").build()
        );

        return ResponseEntity.ok(coffee);
    }
}
