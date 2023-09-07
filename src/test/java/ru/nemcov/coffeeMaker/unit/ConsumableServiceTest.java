package ru.nemcov.coffeeMaker.unit;

import org.junit.jupiter.api.Test;
import ru.nemcov.coffee_maker.repo.ConsumableRepo;
import ru.nemcov.coffee_maker.service.ConsumableService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;

class ConsumableServiceTest {

    private final ConsumableRepo consumableRepo = mock(ConsumableRepo.class);
    private final ConsumableService consumableService = new ConsumableService(consumableRepo);

    @Test
    void shouldFindByCoffeeId() {
        assertThat(consumableService.findByCoffeeId(anyLong())).isNotNull();
    }

}
