package bg.softuni.pizzashop.model.binding;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.entity.Picture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductAddBindingModel {

    private String name;
    private BigDecimal price;
    private String description;
    private Picture picture;
    private Integer grams;
    private Integer ingredientsCount;

    private List<String> IngredientName;
    private List<Integer> IngredientGrams;
}
