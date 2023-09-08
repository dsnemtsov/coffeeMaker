package ru.nemcov.coffeeMaker.unit;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import ru.nemcov.coffee_maker.entity.Coffee;
import ru.nemcov.coffee_maker.entity.Consumable;
import ru.nemcov.coffee_maker.repo.CoffeeRepo;
import ru.nemcov.coffee_maker.service.CoffeeService;
import ru.nemcov.coffee_maker.service.ConsumableService;
import ru.nemcov.coffee_maker.service.IngredientService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CoffeeServiceTest {

    private final CoffeeRepo coffeeRepo = mock(CoffeeRepo.class);
    private final ConsumableService consumableService = mock(ConsumableService.class);
    private final IngredientService ingredientService = mock(IngredientService.class);
    private final CoffeeService service = new CoffeeService(coffeeRepo, consumableService, ingredientService);

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

    @Test
    void shouldOrderCoffee() {
        when(coffeeRepo.findById(anyLong())).thenReturn(Optional.of(new Coffee(
                1L,
                "Ёспрессо",
                true
        )));

        service.orderCoffee(anyLong());
        verify(coffeeRepo).findById(anyLong());
    }

    @Test
    void shouldNotOrderCoffee() {
        when(coffeeRepo.findById(anyLong())).thenReturn(Optional.of(new Coffee(
                1L,
                "Ёспрессо",
                false
        )));

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> service.orderCoffee(1L))
                .withMessage("Coffee is not available");
    }

    @Test
    void shouldSetCoffeeUnavailable() {
        Coffee coffee = Coffee
                .builder()
                .coffeeId(1L)
                .available(true)
                .build();

        Consumable consumable = Consumable
                .builder()
                .quantityRequired(6)
                .build();

        List<Coffee> coffees = List.of(coffee);

        when(coffeeRepo.findAll()).thenReturn(coffees);
        when(consumableService.findByCoffeeId(coffee.getCoffeeId())).thenReturn(List.of(consumable));
        when(ingredientService.checkQuantity(consumable.getIngredientId(), consumable.getQuantityRequired())).thenReturn(false);

        service.updateList();

        assertThat(coffee.isAvailable()).isFalse();
    }
}
