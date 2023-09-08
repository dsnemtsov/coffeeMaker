package ru.nemcov.coffeeMaker.unit;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import ru.nemcov.coffee_maker.entity.Ingredient;
import ru.nemcov.coffee_maker.repo.IngredientRepo;
import ru.nemcov.coffee_maker.service.IngredientService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IngredientServiceTest {

    private final IngredientRepo ingredientRepo = mock(IngredientRepo.class);
    private final IngredientService service = new IngredientService(ingredientRepo);

    @Test
    void shouldGetAllIngredients() {
        assertThat(service.findAll()).isNotNull();
    }

    @Test
    void shouldFindIngredientById() {
        when(ingredientRepo.findById(anyLong())).thenReturn(Optional.of(new Ingredient()));

        service.findById(anyLong());
        verify(ingredientRepo).findById(anyLong());
    }

    @Test
    void shouldReduceIngredient() {
        Ingredient ingredient = Ingredient
                .builder()
                .ingredientId(1L)
                .name("Молоко")
                .quantity(10)
                .build();

        Integer quantityRequired = 6;
        Integer newQuantity = 4;

        when(ingredientRepo.findById(1L)).thenReturn(Optional.of(ingredient));

        service.reduceIngredient(1L, quantityRequired);
        assertThat(ingredient.getQuantity()).isEqualTo(newQuantity);
        verify(ingredientRepo).findById(1L);
        verify(ingredientRepo).save(ingredient);
    }
}
