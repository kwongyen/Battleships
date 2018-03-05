package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.validators.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountVO {
  @NotNull
  @ValidEmail
  @Size(min=5, max=20)
  private String email;
  @NotNull
  @Size(min=4, max=20)
  private String password;
}
