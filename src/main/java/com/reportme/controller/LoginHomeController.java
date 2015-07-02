package com.reportme.controller;

import com.reportme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginHomeController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "home/login";
    }
}
