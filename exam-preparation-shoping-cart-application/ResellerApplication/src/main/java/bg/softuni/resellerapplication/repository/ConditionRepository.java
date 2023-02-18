package bg.softuni.resellerapplication.repository;

import bg.softuni.resellerapplication.model.entity.Condition;
import bg.softuni.resellerapplication.model.enums.ConditionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
    Optional<Condition> findByName(ConditionName name);
}
