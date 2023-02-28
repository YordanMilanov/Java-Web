package bg.softuni.resellerapplication.repository;

import bg.softuni.resellerapplication.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o WHERE o.user.id = ?1")
    List<Offer> findAllByUserOwner();
}
