package softuni.examprepbattleships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.examprepbattleships.domain.entities.Ship;

@Repository
public interface ShipRepository extends JpaRepository <Ship, Long> {
}
