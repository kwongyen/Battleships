package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Account user;
    @ManyToOne
    private Account friend;

    private Date friendsince;
    private int playedagainst;
}
