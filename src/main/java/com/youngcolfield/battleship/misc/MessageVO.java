package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.Account;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class MessageVO {
    private String sender;
    private String receiver;
    private String message;
    private String date;
}
