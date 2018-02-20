package com.youngcolfield.battleship.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int wins;
    private int losses;
    private long playtime;
    private String country;
}
