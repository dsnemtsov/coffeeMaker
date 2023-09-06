package ru.nemcov.coffee_maker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nemcov.coffee_maker.entity.Coffee;

@Service
public class CoffeeService {

    public List<Coffee> getAll() {
        return List.of(
                Coffee.builder().coffeeId(1L).name("Эспрессо").build(),
                Coffee.builder().coffeeId(2L).name("Американо").build(),
                Coffee.builder().coffeeId(3L).name("Каппучино").build(),
                Coffee.builder().coffeeId(4L).name("Мокко").build()
        );
    }
}
