package com.example.mobilelele.domain.entities;

import com.example.mobilelele.domain.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userRoles")
@Getter
@Setter
@NoArgsConstructor
public class UserRole extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Role role;
}
