package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    private LocalDateTime friendsince;
    private int playedagainst;
}
