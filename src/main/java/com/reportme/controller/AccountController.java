package com.reportme.controller;

import com.reportme.model.Group;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/mygroups")
    public ModelAndView myGroups() {
        try {
            return new ModelAndView("account/my-groups", "personObj", personService.getAuthenticatedPerson());
        } catch (NoSuchElementException nsee) {
            SecurityContextHolder.clearContext();
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/belongtogroups")
    public ModelAndView belongToGroups() {
        try {
            return new ModelAndView("account/belong-to-groups", "personObj", personService.getAuthenticatedPerson());
        } catch (NoSuchElementException nsee) {
            SecurityContextHolder.clearContext();
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/newgroup", method = RequestMethod.GET)
    public ModelAndView newGroupForm() {
        return new ModelAndView("account/new-group", "newGroup", new Group());
    }

    @RequestMapping(value = "/newgroup", method = RequestMethod.POST)
    public ModelAndView createNewGroup(@Valid @ModelAttribute("newGroup") Group group, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("account/new-group");
        }else{
            // save the group entity
            return new ModelAndView("redirect:/account/mygroups");
        }
    }
}
