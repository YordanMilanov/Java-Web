package bg.softuni.resellerapplication.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
public class Offer extends BaseEntity{

    @Column(nullable = false)
    private String Description;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Condition condition;

    @ManyToOne
    private User user;
}
