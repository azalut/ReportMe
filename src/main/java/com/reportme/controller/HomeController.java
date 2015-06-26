package com.reportme.controller;

import com.reportme.model.Notification;
import com.reportme.model.NotificationStatus;
import com.reportme.model.Occupant;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class HomeController {
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "/login")
    @Transactional
    public String login() {
        return "home/login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "home/register";
    }
}
