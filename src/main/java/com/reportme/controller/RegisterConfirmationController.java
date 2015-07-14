package com.reportme.controller;

import com.reportme.exception.person.UsernameException;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/confirm")
@Controller
public class RegisterConfirmationController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{confirmationToken}")
    public ModelAndView confirmAccount(@PathVariable("confirmationToken") String confirmationToken,
                                 @RequestParam("username") String username) throws UsernameException {
        personService.enableUser(confirmationToken, username);
        return new ModelAndView("register/register-result", "confirmationMessage", "Twoje konto zostało aktywowane!");
    }
}
