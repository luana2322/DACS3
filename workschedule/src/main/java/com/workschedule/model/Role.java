package com.workschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "role"
)
public class Role {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "role_id"
    )
    private long role_id;
    private String roleName;
    private String description;
    private Date createdAt;
    private Date updatedAt;


    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "user_project_id",
            referencedColumnName = "user_project_id"
    )
    private User_Project userProject;


}
