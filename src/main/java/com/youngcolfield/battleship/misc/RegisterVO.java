package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterVO {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String username;
}
