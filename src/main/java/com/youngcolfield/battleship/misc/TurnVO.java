package com.youngcolfield.battleship.misc;

import lombok.Data;

@Data
public class TurnVO {
  private Long gameId;
  private String move;
  private String playerId;
}
