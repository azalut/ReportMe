package com.reportme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @RequestMapping(value = "/register")
    public String register() {
        return "home/register";
    }

    @RequestMapping(value = "/createAccount")
    public String createAccount(@RequestParam("name") String name,
                                @RequestParam("lastname") String lastname,
                                @RequestParam("email") String email,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("street") String street,
                                @RequestParam("postcode") String postcode,
                                @RequestParam("city") String city,
                                @RequestParam(value = "adminAccount", defaultValue = "false") boolean adminAccount) {
        if(adminAccount){
            //TODO: create admin account
        }else{
            //TODO: create occupant account
        }
        return "home/home"; //TODO: add proper return page
    }
}
