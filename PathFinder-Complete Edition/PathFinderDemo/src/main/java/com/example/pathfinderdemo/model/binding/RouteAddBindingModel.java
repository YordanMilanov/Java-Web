package com.example.pathfinderdemo.model.binding;

import com.example.pathfinderdemo.model.entity.enums.CategoryNameEnum;
import com.example.pathfinderdemo.model.entity.enums.LevelEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RouteAddBindingModel {

    @Size(min = 3, max = 20, message = "Route name must be between 3 and 20 symbols")
    private String name;
    @Size(min = 3, message = "Description name must be atleast 3")
    private String description;

    private MultipartFile gpxCoordinates;

    @NotNull(message = "level must be chosen")
    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    private String videoUrl;

    @Enumerated(EnumType.STRING)
    private Set<CategoryNameEnum> categories;
}
