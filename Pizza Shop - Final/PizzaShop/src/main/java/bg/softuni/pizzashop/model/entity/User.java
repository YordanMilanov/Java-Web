package bg.softuni.pizzashop.model.entity;

import bg.softuni.pizzashop.model.entity.enums.UserLevelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

    @Column
    private String username;

    @Column
    private String fullName;

    @Column
    private String password;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private UserLevelEnum level;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToOne
    private Address address;
}
