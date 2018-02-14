package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Account username;
    @OneToOne
    private Account friendname;

}
