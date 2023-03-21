package bg.softuni.pizzashop.repository;

import bg.softuni.pizzashop.model.entity.Role;
import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE LOWER(r.role) = LOWER(:role)")
    Optional<Role> findByRole(@Param("role") String role);
}
