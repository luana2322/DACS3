package com.workschedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "department"
)
public class Department {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "department_id"
    )
    private int department_id;
    private String department_name;
    private String description;
    private LocalDateTime created_At;
    @OneToMany(
            mappedBy = "department"
    )
    private List<Users> userList;
}
