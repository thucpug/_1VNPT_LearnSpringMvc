package com.tutorialspoint.controller;

import com.tutorialspoint.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HelloController {
    @Autowired
    @Qualifier("person")
    private Person person;

    @RequestMapping(value = {"/hello", "/nn"}, method = RequestMethod.GET)
    public String sayHello(ModelMap map) {
        map.addAttribute("msg", person);
        return "hello";
    }

    @RequestMapping(value = {"/thuc"}, method = RequestMethod.GET)
    public ModelAndView sayHello(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        request.setAttribute("msg", person);
        return new ModelAndView("hello");
    }

    @RequestMapping(value = {"/sayhello"}, method = RequestMethod.GET)
    public ModelAndView sayThuc(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                @RequestParam(name = "user", required = true) String userName,
                                @RequestHeader(name = "Accept", required = false) String accept) {
        request.setAttribute("msg", accept);
        return new ModelAndView("hello");
    }

    @RequestMapping(value = {"/adduser"}, method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request) {
        request.setAttribute("person", new Person("thuc", 22));
        return new ModelAndView("adduser");
    }

    @RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, @ModelAttribute("person") @Valid Person person,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("adduser");
        }
        request.setAttribute("person", person);
        return new ModelAndView("viewuser");
    }
}
