package softuni.examprepbattleships.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BattleShipsModel {

    private Long loggedUserShip;
    private Long notLoggedUserShip;
}
