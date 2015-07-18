package com.reportme.controller;

import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "")
    public ModelAndView accountPage() {
        try {
            return new ModelAndView("account/account", "personObj", personService.getAuthenticatedPerson());
        } catch (NoSuchElementException nsee) {
            SecurityContextHolder.clearContext();
            return new ModelAndView("redirect:/login");
        }
    }
}
