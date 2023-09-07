package ru.nemcov.coffeeMaker.unit;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.repo.CoffeeRepo;
import ru.nemcov.coffee_maker.service.CoffeeService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CoffeeServiceTest {

    private final CoffeeRepo coffeeRepo = mock(CoffeeRepo.class);
    private final CoffeeService service = new CoffeeService(coffeeRepo);

    @Test
    void shouldGetAllCoffee() {
        assertThat(service.findAll()).isNotNull();
    }

    @Test
    void shouldFindCoffeeById() {
        when(coffeeRepo.findById(anyLong())).thenReturn(Optional.of(new Coffee()));

        service.findById(anyLong());
        verify(coffeeRepo).findById(anyLong());
    }

    @Test
    void shouldNotFindCoffeeById() {
        when(coffeeRepo.findById(anyLong())).thenReturn(Optional.empty());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> service.findById(1L))
                .withMessage("Coffee doesn't exist");
    }
}
