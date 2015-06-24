package com.reportme.controller;

import com.reportme.model.SomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private SomeDao someDao;

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        someDao.saveSomeEntity();
        return "home/login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "home/register";
    }
}
