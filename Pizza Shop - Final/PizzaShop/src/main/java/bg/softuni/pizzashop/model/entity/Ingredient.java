package bg.softuni.pizzashop.model.entity;

import bg.softuni.pizzashop.model.entity.enums.IngredientType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@Getter
@Setter
public class Ingredient extends BaseEntity{

    private String name;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;


    private int carbohydrates;
    private int fat;
    private int protein;

    private int calories = (carbohydrates * 4) + (fat * 9) + (protein * 4);

    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;
}
