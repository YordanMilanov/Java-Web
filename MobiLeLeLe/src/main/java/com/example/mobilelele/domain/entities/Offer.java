package com.example.mobilelele.domain.entities;

import com.example.mobilelele.domain.enums.Engine;
import com.example.mobilelele.domain.enums.Transmission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
public class Offer extends BaseEntity{

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    @Column
    private String imageUrl;

    @Column
    private Integer mileage;

    @Column
    private Double price;

    @Column
    private Transmission transmission;

    @Column
    private String year;

    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;
}
