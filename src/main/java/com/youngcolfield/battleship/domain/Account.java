package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;

    @OneToOne
    @JoinColumn(name="stats_id")
    private Stats statsid;

    private String password;
    private String username;

    private int type;
    private String bio;
    private String country;

}
