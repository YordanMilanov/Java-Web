package bg.softuni.finalproject.model.entity;

import bg.softuni.finalproject.model.entity.enums.FoodType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product extends BaseEntity{

    @Column
    private String name;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Column(columnDefinition = "LONG_TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @OneToOne(mappedBy = "product")
    private Picture picture;

    @OneToMany
    private List<Ingredient> ingredients;

    @ManyToOne
    private User addedByUser;
}
