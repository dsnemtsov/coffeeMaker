package ru.nemcov.coffeeMaker.unit;

import org.junit.jupiter.api.Test;
import ru.nemcov.coffee_maker.repo.CoffeeRepo;
import ru.nemcov.coffee_maker.service.CoffeeService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CoffeeServiceTest {

    private final CoffeeRepo coffeeRepo = mock(CoffeeRepo.class);
    private final CoffeeService service = new CoffeeService(coffeeRepo);

    @Test
    void shouldGetAllCoffee() {
        assertThat(service.findAll()).isNotNull();
    }
}
