package com.reportme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "home/login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "home/register";
    }
}
