package com.youngcolfield.battleship.misc;

import lombok.Data;

@Data
public class SimpleAccount {
    private String username;
    private String country;
    private int wins;
    private int losses;
    private double winratio;

    public void SetWinratio(){
        winratio = wins/(wins+losses);
    }

}
