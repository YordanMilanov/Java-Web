package com.example.mobilelele.domain.entities;

import com.example.mobilelele.domain.enums.ModelCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "models")
@Getter
@Setter
@NoArgsConstructor
public class Model extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @Column
    private String imageUrl;

    @Column
    private Integer startYear;

    @Column
    private Integer endYear;

    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    private Brand brand;
}
