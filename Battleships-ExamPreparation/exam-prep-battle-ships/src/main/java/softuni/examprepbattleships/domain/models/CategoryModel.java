package softuni.examprepbattleships.domain.models;
import lombok.*;
import softuni.examprepbattleships.domain.enums.CategoryType;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    private Long id;

    private CategoryType name;

    private String description;
}
