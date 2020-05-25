package com.yyy.social_network.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @Length(min = 4,max = 30)
    private String username;

    @NotNull
    @Length(min = 4,max = 30)
    private String password;

    @NotNull
    @ManyToOne
    private Role role;


}
