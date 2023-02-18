package bg.softuni.resellerapplication.model.entity;

import bg.softuni.resellerapplication.model.enums.ConditionName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conditions")
@Getter
@Setter
@NoArgsConstructor
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private ConditionName name;

    @Column
    private String description;

    public Condition(ConditionName name) {
        this.name = name;
    }
}
