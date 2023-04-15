package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    UserServiceModel findByUsername(String username);

    User getUserByUsername(String username);

    List<UserViewModel> getAll();

    void deleteUser(Long id);

    UserViewModel getUserViewModel(String username);

    UserServiceModel getUserServiceModel(String username);

    public UserViewModel getUserViewModelById(Long id);

    void deleteRole(Long userId, Long roleId) throws Exception;
}
