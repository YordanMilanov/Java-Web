package bg.softuni.pizzashop.model.service;

import bg.softuni.pizzashop.model.entity.Picture;
import bg.softuni.pizzashop.model.entity.enums.IngredientTypeEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductServiceModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Picture picture;
    private Integer grams;
    private Integer ingredientsCount;

    private List<String> IngredientName;
    private List<Integer> IngredientGrams;
}
