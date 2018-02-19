package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageVO {
    @NotNull
    private String sender;
    @NotNull
    private String receiver;
    @NotNull
    private String message;
}
