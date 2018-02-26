package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.Friend;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleFriend {

    private String friendname;
    private String friendEmail;
    private int playedgames;
    private LocalDateTime friendsince;

    public SimpleFriend(Friend f){
        this.friendname = f.getFriend().getUsername();
        this.friendEmail = f.getFriend().getEmail();
        this.playedgames = f.getPlayedgames();
        this.friendsince = f.getFriendsince();
    }
}
