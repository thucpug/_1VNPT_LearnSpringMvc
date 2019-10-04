package com.tutorialspoint.controller;

import com.tutorialspoint.model.Person;
import com.tutorialspoint.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    public ModelAndView addPerson(HttpServletRequest request, @ModelAttribute("person") Person person) {
        List<Person> personList = personService.getAllPersonSevice();
        request.setAttribute("persons",personList);
        return new ModelAndView("/person/viewListAllPerson");
    }
}

