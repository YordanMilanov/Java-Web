package com.example.pathfinderdemo.model.view;

import com.example.pathfinderdemo.model.entity.Category;
import com.example.pathfinderdemo.model.entity.Picture;
import com.example.pathfinderdemo.model.entity.User;
import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RouteDetailsViewModel {

    private String name;
    private String gpxCoordinates;
    private LevelEnum level;
    private String description;
    private String videoUrl;
    private Set<Picture> pictures;
}
