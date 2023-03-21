package bg.softuni.pizzashop.model.service;

import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleServiceModel {

    private Long id;
    private RoleNameEnum role;
    private String description;
}
