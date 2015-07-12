package com.reportme.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameAvailableValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameAvailable {
    String message() default "Username is not available, someone uses it. Please choose another one";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
