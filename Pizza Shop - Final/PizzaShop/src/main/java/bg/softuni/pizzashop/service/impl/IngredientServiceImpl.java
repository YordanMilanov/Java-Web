package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.service.IngredientServiceModel;
import bg.softuni.pizzashop.repository.IngredientRepository;
import bg.softuni.pizzashop.service.IngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    private final ModelMapper modelMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IngredientServiceModel saveIngredient(IngredientServiceModel ingredientServiceModel) {

        Ingredient ingredientToSave = modelMapper.map(ingredientServiceModel, Ingredient.class);

        ingredientToSave.setCalories(ingredientToSave.getProtein() * 4 + ingredientToSave.getFat() * 9  + ingredientToSave.getCarbohydrates() * 4);

        return modelMapper.map(ingredientRepository.save(ingredientToSave), IngredientServiceModel.class);
    }
}
