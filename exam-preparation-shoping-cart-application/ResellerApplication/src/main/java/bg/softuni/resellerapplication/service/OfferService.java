package bg.softuni.resellerapplication.service;

import bg.softuni.resellerapplication.model.entity.Offer;
import bg.softuni.resellerapplication.model.service.OfferServiceModel;

import java.util.List;

public interface OfferService {
    void addOffer(OfferServiceModel offerServiceModel);

    List<Offer> findAllByUserOwner(Long id);
}
