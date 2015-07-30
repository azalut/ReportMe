package com.reportme.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GroupNameAvailableValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GroupNameAvailable {
    String message() default "This group name is not available";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
