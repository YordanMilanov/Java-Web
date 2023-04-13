package com.plannerapp.model.entity;

import com.plannerapp.model.entity.enums.PriorityName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "priorities")
@Getter
@Setter
@NoArgsConstructor
public class Priority extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private PriorityName name;

    @Column
    private String description;

    @OneToMany(mappedBy = "priority")
    private List<Task> tasks;
}
