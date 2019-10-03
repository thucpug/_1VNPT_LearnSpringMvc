package com.tutorialspoint.controller;

import com.tutorialspoint.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = {"/sayhello/{name}/{id}"}, method = RequestMethod.GET)
    public ModelAndView sayThuc1(HttpServletRequest request,
                                 @PathVariable(name = "name", required = true) String url,
                                 @PathVariable(name = "id", required = true) String id) {
        request.setAttribute("msg",url+ id);
        return new ModelAndView("hello");
    }
}
