package bg.softuni.pizzashop.model.binding;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductIngredientsAddBindingModel {

    @Size(min = 3, max = 20, message = "ingredient name must be between 3 and 20 characters")
    private List<String> IngredientName;

    @Positive(message = "ingredient grams must be positive")
    private List<Integer> IngredientGrams;
}
