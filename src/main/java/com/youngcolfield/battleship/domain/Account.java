package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class Account {
    @Id
    private String email;
    private String password;
    private String username;

    private int type;
    private String bio;

    @OneToMany
    private Game game;

}
