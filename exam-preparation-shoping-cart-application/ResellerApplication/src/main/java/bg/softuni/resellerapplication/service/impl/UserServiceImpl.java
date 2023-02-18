package bg.softuni.resellerapplication.service.impl;

import bg.softuni.resellerapplication.model.entity.User;
import bg.softuni.resellerapplication.model.service.UserServiceModel;
import bg.softuni.resellerapplication.repository.UserRepository;
import bg.softuni.resellerapplication.service.UserService;
import bg.softuni.resellerapplication.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;


    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).map(user -> modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public void loginUser(Long id) {
        currentUser.setId(id);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
    }
}
