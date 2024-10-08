package com.ltp.gradesubmission.validation.annotations;

import com.ltp.gradesubmission.validation.validators.ScoreValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {
    String message() default "Invalid Data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
