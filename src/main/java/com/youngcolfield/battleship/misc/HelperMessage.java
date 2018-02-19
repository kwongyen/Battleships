package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.Account;
import com.youngcolfield.battleship.domain.Message;

import java.time.LocalDateTime;

public class HelperMessage {
    private Account sender;
    private String text;
    private LocalDateTime date;


    public HelperMessage(Message m){
        sender = m.getSender();
        text = m.getMessage();
        date = m.getDate();
    }
}
