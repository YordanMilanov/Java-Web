package softuni.examprepbattleships.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import softuni.examprepbattleships.domain.enums.CategoryType;

@Entity
@Table(name = "categories")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
