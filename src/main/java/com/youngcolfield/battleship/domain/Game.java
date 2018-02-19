package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Account playerone;
    @ManyToOne
    private Account playertwo;

    private String currentPlayer;

    @OneToOne
    private BoterKaasEieren boterKaasEieren;

    private String winner;
    private long playtime;

}
