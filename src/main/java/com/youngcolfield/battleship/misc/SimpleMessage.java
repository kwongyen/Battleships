package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.domain.Message;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleMessage {

  private String author;
  private String text;
  private LocalDateTime created;

  public SimpleMessage(){}

  public SimpleMessage(Message message) {
    this.author = message.getSender().getEmail();
    this.text = message.getMessage();
    this.created = message.getDate();
  }
}
