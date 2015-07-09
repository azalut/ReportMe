package com.reportme.controller;

import com.reportme.model.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("home/register");
        modelAndView.addObject("person", new Person());
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createAccount(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("person", person);
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(System.out::println);
            modelAndView.setViewName("home/register");
            return modelAndView;
        }
        modelAndView.setViewName("person/account");
        return modelAndView;
    }
}
