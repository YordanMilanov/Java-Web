package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.service.IngredientServiceModel;

import java.util.List;

public interface IngredientService {
    IngredientServiceModel saveIngredient(IngredientServiceModel ingredientServiceModel);

    List<IngredientServiceModel> findAll();
}
