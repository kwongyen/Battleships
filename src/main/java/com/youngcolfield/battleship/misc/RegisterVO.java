package com.youngcolfield.battleship.misc;

import com.youngcolfield.battleship.validators.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterVO {
    @NotNull
    @ValidEmail
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String username;
    private String country;
}
