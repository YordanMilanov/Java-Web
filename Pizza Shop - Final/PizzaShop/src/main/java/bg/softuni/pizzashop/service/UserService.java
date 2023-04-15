package bg.softuni.pizzashop.service;

import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    List<UserViewModel> getAll();

    void deleteUser(Long id);

    UserViewModel getUserViewModel(String username);

    public UserViewModel getUserViewModelById(Long id);

    void deleteRole(Long userId, Long roleId) throws Exception;

    void addRoleToUser(Long userId, String selectedRole) throws Exception;

    boolean isUsernameUsed(String username);

    void updateUsername(String oldName, String username);
}
