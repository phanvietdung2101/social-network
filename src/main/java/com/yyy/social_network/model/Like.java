package com.yyy.social_network.model;

import lombok.Data;
import org.springframework.data.domain.Auditable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "`like`")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @NotNull
    private User user;
    
}
