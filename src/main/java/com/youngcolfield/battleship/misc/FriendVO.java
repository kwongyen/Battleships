package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class FriendVO {
    @NotNull
    private String user;
    @NotNull
    private String friend;
}
