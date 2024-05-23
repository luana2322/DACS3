package com.workschedule.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "user_project"
        , uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "user_id"})
)
@Builder
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

    @OneToOne(mappedBy = "userProject",
            cascade = {CascadeType.ALL}
    )
    private Role role;
}
