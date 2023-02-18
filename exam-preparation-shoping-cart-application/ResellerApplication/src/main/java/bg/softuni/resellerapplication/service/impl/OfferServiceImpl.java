package bg.softuni.resellerapplication.service.impl;

import bg.softuni.resellerapplication.model.entity.Condition;
import bg.softuni.resellerapplication.model.entity.Offer;
import bg.softuni.resellerapplication.model.entity.User;
import bg.softuni.resellerapplication.model.service.OfferServiceModel;
import bg.softuni.resellerapplication.repository.ConditionRepository;
import bg.softuni.resellerapplication.repository.OfferRepository;
import bg.softuni.resellerapplication.repository.UserRepository;
import bg.softuni.resellerapplication.service.OfferService;
import bg.softuni.resellerapplication.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final CurrentUser currentUser;

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    private final ConditionRepository conditionRepository;

    private final UserRepository userRepository;

    public OfferServiceImpl(CurrentUser currentUser, OfferRepository offerRepository, ModelMapper modelMapper, ConditionRepository conditionRepository, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer offerToSave = modelMapper.map(offerServiceModel, Offer.class);
        Condition conditionToSave = conditionRepository.findByName(offerServiceModel.getCondition()).get();
        User userToSave = userRepository.findById(currentUser.getId()).get();
        offerToSave.setCondition(conditionToSave);
        offerToSave.setUser(userToSave);
        offerRepository.save(offerToSave);
    }

    @Override
    public List<Offer> findAllByUserOwner() {
        return offerRepository.findAllByUserOwner(Long id);
    }
}
