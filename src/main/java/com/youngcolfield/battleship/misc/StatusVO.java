package com.youngcolfield.battleship.misc;

import lombok.Getter;

@Getter
public class StatusVO {

  public static final StatusVO OK = new StatusVO("OK");
  public static final StatusVO EMPTY = new StatusVO();

  private String status;

  private StatusVO() {}

  public StatusVO(final String status) {
    this.status = status;
  }
}