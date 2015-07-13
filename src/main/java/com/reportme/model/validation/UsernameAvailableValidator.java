package com.reportme.model.validation;

import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameAvailableValidator implements ConstraintValidator<UsernameAvailable, String> {
    @Autowired
    private PersonService personService;

    @Override
    public void initialize(UsernameAvailable usernameAvailable) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(personService == null) {
            return true;
        }
        return personService.containsA(username);
    }
}
