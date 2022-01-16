package com.springboot.learning.validated.service;

import com.springboot.learning.validated.annotation.isEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isEmailValidated implements ConstraintValidator<isEmail, String> {
    private static final Pattern emailPattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$");
    private boolean notNull = false;

    @Override
    public void initialize(isEmail constraintAnnotation) {
        notNull = constraintAnnotation.notNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (notNull) {
            return isEmailStr(value);
        } else {
            if (value == null) {
                return true;
            } else {
                return isEmailStr(value);
            }
        }
    }

    private static boolean isEmailStr(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}
