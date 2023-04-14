package bg.softuni.pizzashop.model.view;

import bg.softuni.pizzashop.model.entity.BaseEntity;
import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.entity.Picture;
import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ProductViewModel {

    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private String pictureURL;

    private Integer grams;

    private double caloriesPer100;

    private ProductTypeEnum productTypeEnum;
}
