package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity{

    @Column(unique = true)
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private LocalDateTime neededBefore;

    @ManyToOne
    private Category category;
}
