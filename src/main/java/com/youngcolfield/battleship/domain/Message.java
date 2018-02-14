package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Game game;
    @ManyToOne
    private Account sender;
    @ManyToOne
    private Account receiver;

    private String message;
    private Date date;
}
