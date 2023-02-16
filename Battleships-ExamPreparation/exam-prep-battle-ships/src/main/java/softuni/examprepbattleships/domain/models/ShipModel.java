package softuni.examprepbattleships.domain.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryModel category;
    private UserModel user;
}
