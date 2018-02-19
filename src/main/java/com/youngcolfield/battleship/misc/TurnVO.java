package com.youngcolfield.battleship.misc;

import lombok.Data;

@Data
public class TurnVO {
  private Long gameId;
  private Long move;
  private String playerId;
}
