package bg.softuni.pizzashop.model.binding;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class ProductIngredientsAddBindingModel {

    @Size(min = 3, max = 20, message = "ingredient name must be between 3 and 20 characters")
    private List<String> IngredientNames = new ArrayList<>();

    @Positive(message = "ingredient grams must be positive")
    private List<Integer> IngredientGrams = new ArrayList<>();

    public List<String> getIngredientNames() {
        return IngredientNames;
    }

    public void setIngredientNames(List<String> ingredientNames) {
        IngredientNames = ingredientNames;
    }

    public List<Integer> getIngredientGrams() {
        return IngredientGrams;
    }

    public void setIngredientGrams(List<Integer> ingredientGrams) {
        IngredientGrams = ingredientGrams;
    }
}
