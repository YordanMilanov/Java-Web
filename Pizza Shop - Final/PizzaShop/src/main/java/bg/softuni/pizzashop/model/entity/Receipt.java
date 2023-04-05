package bg.softuni.pizzashop.model.entity;

import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "receipts")
//@NoArgsConstructor
//@Getter
//@Setter
public class Receipt extends BaseEntity{

    //NOT USED

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ProductTypeEnum productTypeEnum;

    //to be calculated in the service!
    @Column
    private Integer grams;
}
