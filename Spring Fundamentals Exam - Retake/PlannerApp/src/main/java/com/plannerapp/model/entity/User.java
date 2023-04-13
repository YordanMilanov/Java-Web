package com.plannerapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Task> assignedTasks;
}
