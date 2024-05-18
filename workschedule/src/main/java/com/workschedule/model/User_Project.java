package com.workschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "user_project"
)
public class User_Project {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long user_project_id;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "project_id",
            referencedColumnName = "project_id"
    )
    private Project project;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "user_id"
    )
    private Users users;

    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "role_id"
    )
    private Role role;
}
