package softuni.examprepbattleships.domain.models.binding;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.examprepbattleships.domain.models.CategoryModel;
import softuni.examprepbattleships.validations.checkShipExistence.ValidateExistenceOfShip;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class ShipAddModel {

    @NotNull
    @Size(min = 2, max = 10)
    @ValidateExistenceOfShip
    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @PastOrPresent
    private Date created;

    @NotNull
    private CategoryModel category;
}
