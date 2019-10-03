package com.tutorialspoint.controller;

import com.tutorialspoint.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
