package com.springboot.learning.validated.annotation;

import com.springboot.learning.validated.service.isEmailValidated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {isEmailValidated.class})
@Documented
public @interface isEmail {
    String message() default "email 格式错误";
    String value() default "email 格式错误";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    boolean notNull() default true;
}
