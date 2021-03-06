package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GameIdVO {
  @NotNull
  private String playerId;
  @NotNull
  private Long gameId;

}
