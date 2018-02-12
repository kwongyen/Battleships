package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Account {
    @Id
    private String email;

    private int type;
    private String password;
    private String username;

}
