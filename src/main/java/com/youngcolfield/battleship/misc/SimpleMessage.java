package com.youngcolfield.battleship.misc;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleMessage {

  private String message;
  private LocalDateTime date;

}
