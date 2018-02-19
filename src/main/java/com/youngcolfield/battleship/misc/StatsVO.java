package com.youngcolfield.battleship.misc;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StatsVO {
    @NotNull
    private String username;
}
