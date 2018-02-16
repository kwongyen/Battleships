package com.youngcolfield.battleship.misc;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FriendVO {
    private String user;
    private String friend;
    private int playedgames;
    private LocalDateTime friendsince;
}
