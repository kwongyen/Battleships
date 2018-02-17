package com.youngcolfield.battleship.misc;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleFriend {

    private String friendname;
    private int playedgames;
    private LocalDateTime friendsince;
}
