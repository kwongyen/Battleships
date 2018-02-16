package com.youngcolfield.battleship.misc;

import lombok.Data;

@Data
public class MessageVO {
    private String sender;
    private String receiver;
    private String message;
}
