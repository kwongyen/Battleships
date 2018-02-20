package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.Message;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleMessage {

  private String message;
  private LocalDateTime date;

  public SimpleMessage(){}

  public SimpleMessage(Message message) {
    this.message = message.getMessage();
    this.date = message.getDate();
  }
}
