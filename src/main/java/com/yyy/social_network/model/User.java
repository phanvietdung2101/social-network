package com.yyy.social_network.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Length(min = 4,max = 30)
    private String fullName;

    @URL
    private String avatarUrl;

    @NotNull
    @Length(min = 4,max = 30)
    private String username;

    @NotNull
    @Length(min = 4,max = 30)
    private String password;

    @NotNull
    @ManyToOne
    private Role role;

    private String bio;

    private String personalWebsite;

    @ManyToMany
    @JsonIgnore
    private List<User> followingList;

    @ManyToMany
    @JsonIgnore
    private List<User> followersList;






}
