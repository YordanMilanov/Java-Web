package softuni.examprepbattleships.services;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.examprepbattleships.domain.entities.Ship;
import softuni.examprepbattleships.domain.helpers.LoggedUser;
import softuni.examprepbattleships.domain.models.CategoryModel;
import softuni.examprepbattleships.domain.models.ShipModel;
import softuni.examprepbattleships.domain.models.UserModel;
import softuni.examprepbattleships.domain.models.binding.ShipAddModel;
import softuni.examprepbattleships.repositories.ShipRepository;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;
    private final UserService userService;
    private final CategoryService categoryService;


    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public void addShip(ShipAddModel addModel) {
        UserModel loggedUser = this.userService.findById(this.loggedUser.getId());
        CategoryModel categoryModel = this.categoryService.findByName(addModel.getCategory());

        Ship shipToSave = this.modelMapper.map(new ShipModel().builder()
                .category(categoryModel)
                .created(addModel.getCreated())
                .name(addModel.getName())
                .power(addModel.getPower())
                .health(addModel.getHealth())
                .user(loggedUser)
                .build(), Ship.class);

        this.shipRepository.saveAndFlush(shipToSave);
    }
}
