package com.springboot.learning.validated.service;

import com.springboot.learning.validated.annotation.IsPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordValidated implements ConstraintValidator<IsPassword, String> {
    @Override
    public void initialize(IsPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
