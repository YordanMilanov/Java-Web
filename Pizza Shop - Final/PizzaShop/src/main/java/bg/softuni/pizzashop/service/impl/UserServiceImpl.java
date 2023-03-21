package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.repository.RoleRepository;
import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.util.CurrentUser;
import bg.softuni.pizzashop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

        //make the first registered admin
        if(userRepository.count() == 0) {
            user.setRoles(roleRepository.findAll().stream().collect(Collectors.toSet()));
            user.setLevel(UserLevelEnum.EMPLOYEE);
        } else {

            user.setRoles(new HashSet<>());
            user.getRoles().add(roleRepository.findByRole(RoleNameEnum.CUSTOMER.toString()).get());
            user.setLevel(UserLevelEnum.REGULAR);
        }

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        UserServiceModel userServiceModel = userRepository.findByUsernameAndPassword(username, password).map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
        return userServiceModel;
//        return userRepository.findByUsernameAndPassword(username, password).map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public void loginUser(Long id, String username, Set<Role> roles, UserLevelEnum level) {
        currentUser.setId(id);
        currentUser.setUsername(username);
        currentUser.setRoles(roles);
        currentUser.setLevel(level);
    }
}
