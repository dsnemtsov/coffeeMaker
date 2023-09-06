package ru.nemcov.coffee_maker.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nemcov.coffee_maker.entity.Coffee;

@RestController
public class CoffeeController {

    @GetMapping
    public ResponseEntity<List<Coffee>> getAll() {
        List<Coffee> coffee = List.of(
                Coffee.builder().coffeeId(1L).name("Espresso").build(),
                Coffee.builder().coffeeId(2L).name("Americano").build(),
                Coffee.builder().coffeeId(3L).name("Cappuccino").build(),
                Coffee.builder().coffeeId(4L).name("Mocha").build()
        );

        return ResponseEntity.ok(coffee);
    }
}
