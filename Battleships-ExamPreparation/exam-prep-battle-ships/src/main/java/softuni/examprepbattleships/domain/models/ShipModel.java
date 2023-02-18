package softuni.examprepbattleships.domain.models;

import lombok.*;

import java.time.LocalDate;

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
