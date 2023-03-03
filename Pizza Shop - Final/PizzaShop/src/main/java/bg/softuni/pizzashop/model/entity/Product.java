package bg.softuni.pizzashop.model.entity;

import bg.softuni.pizzashop.model.entity.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @OneToOne
    private Picture picture;

    @OneToMany
    private List<Ingredient> ingredients;

}
