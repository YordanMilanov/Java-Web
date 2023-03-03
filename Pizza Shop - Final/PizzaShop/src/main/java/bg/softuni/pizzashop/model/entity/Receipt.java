package bg.softuni.pizzashop.model.entity;

import bg.softuni.pizzashop.model.entity.enums.ProductSizeEnum;
import bg.softuni.pizzashop.model.entity.enums.ReceiptCategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "receipts")
@NoArgsConstructor
@Getter
@Setter
public class Receipt extends BaseEntity{

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ReceiptCategoryEnum receiptCategoryEnum;

    //depends on the product grams
    @Enumerated(EnumType.STRING)
    private ProductSizeEnum productSizeEnum;

    @OneToMany
    @MapKeyColumn(name="required_quantity")
    private Map<Integer, Receipt> requiredIngredients;

    //to be calculated in the service!
    @Column
    private Integer grams;
}
