package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GameVO {
  @NotNull
  private String playerId;
}
