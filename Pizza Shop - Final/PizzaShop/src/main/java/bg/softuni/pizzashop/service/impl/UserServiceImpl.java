package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.repository.RoleRepository;
import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

   private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        UserServiceModel userServiceModel = userRepository.findByUsername(username).map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
        return userServiceModel;
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


    public UserViewModel getUserViewModelById(Long id) {
        return modelMapper.map(userRepository.findById(id).get(), UserViewModel.class);
    }

    @Override
    public void deleteRole(Long userId, Long roleId) throws Exception{
        User user = userRepository.findById(userId).get();
        Role role = roleRepository.findById(roleId).get();
        Set<Role> roles = user.getRoles();

        //if the user is left with no roles set his rank to the lowest
        if(roles.size() <= 1) {
            Role customerRole = roleRepository.findByRole("CUSTOMER").get();
            Set<Role> customerRoleSet = new HashSet<>(Collections.singleton(customerRole));
            user.setRoles(customerRoleSet);
            userRepository.save(user);
            throw new Exception("User must have at least one role! The rank of the account is set to the lowest possible - CUSTOMER");
        }

        //remove role
        for (Role currentRole : roles) {
            if(currentRole.getRole() == role.getRole()) {
                roles.remove(currentRole);
                break;
            }
        }

        //update user
        user.setRoles(roles);
        userRepository.save(user);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserViewModel getUserViewModel(String username) {
     return modelMapper.map(userRepository.findByUsername(username), UserViewModel.class);
    }

    @Override
    public UserServiceModel getUserServiceModel(String username) {
        return modelMapper.map(userRepository.findByUsername(username), UserServiceModel.class);
    }
}
