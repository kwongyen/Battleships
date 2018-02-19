package com.youngcolfield.battleship.exceptions;

public class InvalidTurnException extends Exception {
  public InvalidTurnException(String message){
    super (message);
  }
}
