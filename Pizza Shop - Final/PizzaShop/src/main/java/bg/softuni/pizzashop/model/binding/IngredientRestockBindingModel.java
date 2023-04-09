package bg.softuni.pizzashop.model.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientRestockBindingModel {

    private Long id;

    private String name;

    private BigDecimal price;

    @Positive(message = "Stock Must be greater than 0")
    @NotNull(message = "Field Cannot be empty")
    private BigDecimal stockInKg;
}
