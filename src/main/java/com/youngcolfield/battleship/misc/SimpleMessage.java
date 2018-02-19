package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.Message;

import java.time.LocalDateTime;

public class SimpleMessage {

  private String message;
  private LocalDateTime date;

  public SimpleMessage(Message message) {
    this.message = message.getMessage();
    this.date = message.getDate();
  }
}
