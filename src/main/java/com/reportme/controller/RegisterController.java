package com.reportme.controller;

import com.reportme.model.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "person/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createAccount(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person/register";
        }
        return "person/account";
    }
}
