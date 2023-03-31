package bg.softuni.pizzashop.model.binding;

import bg.softuni.pizzashop.model.entity.Ingredient;
import bg.softuni.pizzashop.model.entity.Picture;
import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class ProductAddBindingModel {

    private String name;
    private BigDecimal price;
    private String description;
    private ProductTypeEnum productTypeEnum;
    private MultipartFile picture;
}
