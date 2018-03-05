package com.youngcolfield.battleship.util;

public class StringUtil {

  private static final String REGEX = "[<>()\"';/\\\\{}\n]";
  private static final String EMPTY = "";

  static public Boolean validString(String input) {
    String value = input;
    if (input == null || input.length() == 0) {
      return false;
    }
    input = input.replaceAll(REGEX, EMPTY);
    return value.equals(input);
  }
}
