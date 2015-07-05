package com.reportme.controller;

import com.reportme.model.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("home/register");
        modelAndView.addObject("person", new Person());
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createAccount(@ModelAttribute("person") Person person) {
        //TODO: create account
        ModelAndView modelAndView = new ModelAndView("person/account");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
