package softuni.examprepbattleships.domain.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserWithShipsModel {

    private UserModel userModel;
    private List<ShipModel> shipModels;

}
