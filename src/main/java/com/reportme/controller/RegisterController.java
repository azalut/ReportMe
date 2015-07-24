package com.reportme.controller;

import com.reportme.exception.person.ConfirmationTokenException;
import com.reportme.exception.person.RegisterException;
import com.reportme.exception.person.UsernameException;
import com.reportme.model.person.Person;
import com.reportme.service.person.ConfirmationEmailSenderService;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    @Qualifier("personService")
    private PersonService personService;
    @Autowired
    private ConfirmationEmailSenderService confirmationEmailSenderService;

    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createAccount(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) throws RegisterException, UsernameException, ConfirmationTokenException {
        if (bindingResult.hasErrors()) {
            return "register/register";
        }else{
            if(personService.create(person).isPresent()){
                confirmationEmailSenderService.sendConfirmationEmail(person);
            }else{
                throw new RegisterException("Person instance was not created properly");
            }
            return "redirect:/login?registerSuccess=true";
        }
    }

    @RequestMapping(value = "/confirm/{confirmationToken}")
    public ModelAndView confirmAccount(@PathVariable("confirmationToken") String confirmationToken,
                                       @RequestParam("username") String username) throws UsernameException, ConfirmationTokenException {
        personService.enableUser(confirmationToken, username);

        return new ModelAndView("register/confirmation-result", "isConfirmationSucceed", true);
    }
}
