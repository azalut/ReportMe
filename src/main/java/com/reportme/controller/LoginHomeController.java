package com.reportme.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginHomeController {

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "loginhome/home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "loginhome/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }
}
