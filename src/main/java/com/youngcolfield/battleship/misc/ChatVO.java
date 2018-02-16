package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChatVO {
  @NotNull
  private String receiverId;
  @NotNull
  private String senderId;
}
