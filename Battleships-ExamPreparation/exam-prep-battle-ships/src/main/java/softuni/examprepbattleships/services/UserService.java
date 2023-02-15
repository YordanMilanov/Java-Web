package softuni.examprepbattleships.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.examprepbattleships.domain.entities.User;
import softuni.examprepbattleships.domain.models.binding.UserModel;
import softuni.examprepbattleships.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserModel findByUsername(String username) {
        return this.modelMapper
                .map(this.userRepository.findByUsername(username)
                        .orElse(new User()), UserModel.class);
    }
}
