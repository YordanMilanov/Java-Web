package bg.softuni.pizzashop.repository;

import bg.softuni.pizzashop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
