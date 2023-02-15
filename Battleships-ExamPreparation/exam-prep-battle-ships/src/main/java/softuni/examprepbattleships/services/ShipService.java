package softuni.examprepbattleships.services;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.examprepbattleships.domain.helpers.LoggedUser;
import softuni.examprepbattleships.domain.models.UserModel;
import softuni.examprepbattleships.domain.models.binding.ShipAddModel;
import softuni.examprepbattleships.repositories.ShipRepository;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;
    private final UserService userService;


    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }


    public void addShip(ShipAddModel AddModel) {
        UserModel byId = this.userService.findById(loggedUser.getId());
    }
}
