package com.youngcolfield.battleship.validators;

import com.youngcolfield.battleship.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

  @Override
  public void initialize(ValidEmail validEmailConstraint) {}

  @Override
  public boolean isValid(final String input, final ConstraintValidatorContext constraintValidatorContext) {
    if (!StringUtil.validString(input)){
      return false;
    }

    /// check for correct email


    return true;
  }
}
