package softuni.examprepbattleships.domain.models.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.examprepbattleships.domain.enums.CategoryType;
import softuni.examprepbattleships.validations.checkShipExistence.ValidateExistenceOfShip;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate created;

    @NotNull
    private CategoryType category;
}
