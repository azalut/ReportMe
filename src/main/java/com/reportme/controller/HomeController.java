package com.reportme.controller;

import com.reportme.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;

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
        // ADMIN
        PersonData adminPersonData = new PersonData("nickname", "haslo", "imie", "nazwisko", "email@email.pl");
        Address address = new Address("ulica", "78-100", "kolobrzeg");
        Administrator administrator = new Administrator(adminPersonData, true, new HashSet<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_OCCUPANT)), address);
        entityManager.persist(administrator);

        // SAVE NEW GROUP
        Group group = new Group("ul_e_gierczak");
        entityManager.persist(group);

        //PERSISTING NOTIFICATION
        Notification notification = new Notification("tytul", "opis", administrator, NotificationStatus.FOR_CONSIDERATION);
        entityManager.persist(notification);

        administrator.getCreatedGroups().add(group);
        administrator.getMyNotifications().add(notification);



        return "home/login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "home/register";
    }
}
