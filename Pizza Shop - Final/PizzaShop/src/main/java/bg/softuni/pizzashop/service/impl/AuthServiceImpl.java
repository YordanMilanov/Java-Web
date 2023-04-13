package bg.softuni.pizzashop.service.impl;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.User;
import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void loginUser(Long id, String username, Set<Role> roles, UserLevelEnum level) {
//        OrderServiceModel order = new OrderServiceModel();
//        order.setOrderStatus(OrderStatusEnum.IN_PROCESS);
//        order.setPrice(BigDecimal.ZERO);
//        order.setOrderTime(null);
//        order.setDescription("");
//        order.setProducts(new ArrayList<>());
//        order.setProductNameQuantity(new HashMap<>());
//        User user = userRepository.findByUsername(username).get();
//        order.setUser(user);
//        currentUser.setId(id);
//        currentUser.setUsername(username);
//        currentUser.setRoles(roles);
//        currentUser.setLevel(level);
//        currentUser.setCurrentOrder(order);
//        currentUser.setUser(userRepository.findByUsername(username).get());
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        User user = modelMapper.map(userServiceModel, User.class);


//        make the first registered admin
//        if(userRepository.count() == 0) {
//            user.setRoles(roleRepository.findAll().stream().collect(Collectors.toSet()));
//            user.setLevel(UserLevelEnum.EMPLOYEE);
//        } else {
//            user.setRoles(new HashSet<>());
//            user.getRoles().add(roleRepository.findByRole(RoleNameEnum.CUSTOMER.toString()).get());
//            user.setLevel(UserLevelEnum.REGULAR);
//        }

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found!"));
    }
}
