package com.reportme.controller;

import com.reportme.model.Group;
import com.reportme.service.group.GroupService;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private GroupService groupService;

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
            groupService.create(group);
            return new ModelAndView("redirect:/account/mygroups");
        }
    }

    @RequestMapping(value = "/group/{groupName}")
    public ModelAndView selectedGroup(@PathVariable("groupName") String groupName) {
        return new ModelAndView("account/group", "group", groupService.findByGroupName(groupName).get());
    }

    @RequestMapping(value = "/delete/{groupName}")
    public String deleteGroup(@PathVariable("groupName") String groupName) {
        System.out.println("WLASNIE USUWAM GRUPE " + groupName);
        groupService.deleteByName(groupName);
        return "redirect:/account/mygroups";
    }
}
