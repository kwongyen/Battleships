package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {
    @Id
    private String email;

    @OneToOne
    private Stats stats;

    private String password;
    private String username;
    private int type;
    private String bio;



}
