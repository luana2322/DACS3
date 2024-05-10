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
        name = "user_role"
)
public class User_Role {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long user_role_id;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "role_id"
    )
    private Role role;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "user_id"
    )
    private Users users;
}
