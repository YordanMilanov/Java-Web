package com.example.pathfinderdemo.model.entity;


import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
public class Route extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @ManyToOne
    private User author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String videoUrl;

    @ManyToMany
    private Set<Category> categories;
}
