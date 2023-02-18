package bg.softuni.resellerapplication.model.binding;

import bg.softuni.resellerapplication.model.enums.ConditionName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferAddBindingModel {

    @Size(min = 2, max = 20, message = "Description length must be between 2 and 50 characters")
    private String description;

    @Positive(message = "The price must be a positive number")
    private String price;

    @NotNull
    private ConditionName condition;
}
