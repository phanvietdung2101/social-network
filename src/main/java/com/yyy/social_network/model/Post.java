package com.yyy.social_network.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @URL
    private String imageUrl;

    @NotEmpty
    private String text;

    @Column(columnDefinition = "int default 0")
    private long liked_quantity;

    @ManyToOne
    private User user;


}
