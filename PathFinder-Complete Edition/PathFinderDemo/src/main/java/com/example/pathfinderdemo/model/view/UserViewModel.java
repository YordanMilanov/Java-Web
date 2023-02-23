package com.example.pathfinderdemo.model.view;

import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserViewModel {

    private Long id;
    private String fullName;
    private String username;
    private Integer age;
    private LevelEnum level;
}
