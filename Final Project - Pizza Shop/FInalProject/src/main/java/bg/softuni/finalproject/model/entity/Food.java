package bg.softuni.finalproject.model.entity;

import bg.softuni.finalproject.model.entity.enums.FoodSize;
import bg.softuni.finalproject.model.entity.enums.FoodType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "foods")
@NoArgsConstructor
public class Food extends BaseEntity{

    @Column
    private String name;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Column(columnDefinition = "LONG_TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @OneToOne
    private Picture picture;

    @OneToMany
    private List<Ingredient> ingredients;


}
