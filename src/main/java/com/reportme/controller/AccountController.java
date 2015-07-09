package com.reportme.controller;

import com.reportme.model.person.Person;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller("/account")
public class AccountController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{username}")
    public ModelAndView myAccountPage(@PathVariable final String username) {
        Optional<Person> personOptional = personService.findByUsername(username);
        if(personOptional.isPresent()){
            return new ModelAndView("account/account", "createdPerson", personOptional.get());
        }else{
            return new ModelAndView("loginhome/login");
        }
    }
}
