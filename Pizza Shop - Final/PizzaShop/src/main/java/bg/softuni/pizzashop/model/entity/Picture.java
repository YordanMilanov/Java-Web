package bg.softuni.pizzashop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pictures")
@NoArgsConstructor
@Getter
@Setter
public class Picture extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] data;
}
