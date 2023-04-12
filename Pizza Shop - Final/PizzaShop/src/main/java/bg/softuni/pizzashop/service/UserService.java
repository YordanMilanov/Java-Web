package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;
import java.util.List;
import java.util.Set;

public interface UserService {

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User getUserByUsername(String username);

    List<UserViewModel> getAll();

    void deleteUser(Long id);
}
