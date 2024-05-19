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
        name = "project"
)
public class Project {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "project_id"
    )
    private long project_id;
    private String projectName;
    private String projectStatus;
    private Long projectowner;
    private Date timeStart;
    private Date timeEnd;
    private String projectDescription;


    @OneToMany(
            mappedBy = "project"
    )
    private List<User_Project> userProjectList;
}
