package com.reportme.controller;

import com.reportme.exception.person.UsernameNotAvailableException;
import com.reportme.model.person.Person;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    @Qualifier("personService")
    private PersonService personService;

    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createAccount(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) throws UsernameNotAvailableException {
        if (bindingResult.hasErrors()) {
            return "register/register";
        }else{
            personService.create(person);
            return "loginhome/login";
        }
    }
}
