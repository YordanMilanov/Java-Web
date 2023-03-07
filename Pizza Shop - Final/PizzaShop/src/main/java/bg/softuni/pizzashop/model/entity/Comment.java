package bg.softuni.pizzashop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
public class Comment extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @Column(name = "created")
    private LocalDateTime created;

    @ManyToOne
    private User author;

    @ManyToOne
    private Product product;
}
