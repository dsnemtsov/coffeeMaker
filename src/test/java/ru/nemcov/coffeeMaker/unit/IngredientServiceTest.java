package ru.nemcov.coffeeMaker.unit;

import org.junit.jupiter.api.Test;
import ru.nemcov.coffee_maker.repo.IngredientRepo;
import ru.nemcov.coffee_maker.service.IngredientService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class IngredientServiceTest {

    private final IngredientRepo ingredientRepo = mock(IngredientRepo.class);
    private final IngredientService service = new IngredientService(ingredientRepo);

    @Test
    void shouldGetAllIngredients() {
        assertThat(service.findAll()).isNotNull();
    }
}
