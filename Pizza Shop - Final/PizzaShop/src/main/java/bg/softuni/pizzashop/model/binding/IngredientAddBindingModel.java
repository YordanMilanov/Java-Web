package bg.softuni.pizzashop.model.binding;

import bg.softuni.pizzashop.model.entity.enums.IngredientTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientAddBindingModel {

    private String name;

    private BigDecimal price;

    private BigDecimal stockInGrams;

    private int carbohydrates;

    private int fat;

    private int protein;

    private IngredientTypeEnum ingredientTypeEnum;
}
