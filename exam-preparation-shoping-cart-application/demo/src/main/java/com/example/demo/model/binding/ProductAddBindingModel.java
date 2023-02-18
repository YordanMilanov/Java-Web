package com.example.demo.model.binding;

import com.example.demo.model.entity.CategoryNameEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class ProductAddBindingModel {

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 character")
    private String name;

    @Size(min = 5, message = "Description must be minimum 5 characters")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    private LocalDateTime neededBefore;

    @DecimalMin(value = "0", message = "price must be positive")
    private BigDecimal price;

    @NotNull(message = "You must select the category")
    private CategoryNameEnum category;
}
