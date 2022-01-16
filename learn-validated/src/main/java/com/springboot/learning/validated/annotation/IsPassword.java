package com.springboot.learning.validated.annotation;

import com.springboot.learning.validated.service.isEmailValidated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD,ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {isEmailValidated.class})
@Documented
public @interface IsPassword {
    String message() default "{com.springboot.learning.validated.annotation.IsPassword}";
    String value() default "是密码";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    boolean notNull() default true;
}
