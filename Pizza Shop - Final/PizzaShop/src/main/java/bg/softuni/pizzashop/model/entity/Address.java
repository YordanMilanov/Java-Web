package bg.softuni.pizzashop.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {

    @Column
    private String city;

    @Column
    private String neighborhood;

    @Column
    private String street;

    @Column
    private int streetNumber;

    @Column
    private int floor;

    @Column
    private int apart;
}
