package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import bg.softuni.pizzashop.model.service.OrderServiceModel;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.repository.RoleRepository;
import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.service.UserService;
import bg.softuni.pizzashop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    private final RoleRepository roleRepository;

   private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        UserServiceModel userServiceModel = userRepository.findByUsernameAndPassword(username, password).map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
        return userServiceModel;
//        return userRepository.findByUsernameAndPassword(username, password).map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }



    @Override
    public List<UserViewModel> getAll() {
        List<User> allUsers = userRepository.findAll();

        List<UserViewModel> collect = allUsers.stream().map(user -> modelMapper.map(user, UserViewModel.class))
                .collect(Collectors.toList());
        return collect;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found!"));
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
