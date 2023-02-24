package com.example.pathfinderdemo.model.service;

import com.example.pathfinderdemo.model.entity.Category;
import com.example.pathfinderdemo.model.entity.Picture;
import com.example.pathfinderdemo.model.entity.User;
import com.example.pathfinderdemo.model.entity.enums.CategoryNameEnum;
import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class RouteServiceModel {

    private Long id;
    private String name;
    private String gpxCoordinates;
    private LevelEnum level;
    private User author;
    private String description;
    private String videoUrl;
    private Set<Picture> pictures;
    private Set<CategoryNameEnum> categories;


}
