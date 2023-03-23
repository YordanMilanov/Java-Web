package bg.softuni.pizzashop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private Picture picture;

    @Column
    private Integer grams;

    //the relation table between the 2 entities
    @ElementCollection
    //naming of the table
    @CollectionTable(name = "required_ingredients")
    //naming of the key-column
    @MapKeyJoinColumn(name = "ingredient")
    //naming of the value-column
    @Column(name = "grams")
    private Map<Ingredient, Integer> requiredProducts;
}
