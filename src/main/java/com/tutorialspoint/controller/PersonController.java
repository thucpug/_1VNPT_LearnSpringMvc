package com.tutorialspoint.controller;

import com.tutorialspoint.model.Person;
import com.tutorialspoint.service.IPersonService;
import com.tutorialspoint.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    IPersonService iPersonService;

    @RequestMapping(value = "/list-person", method = RequestMethod.GET)
    public ModelAndView showListPerson(HttpServletRequest request) {
        List<Person> personList = iPersonService.getAllPersonSevice();
        request.setAttribute("persons", personList);
        System.out.println(personList.get(0).getName());
        return new ModelAndView("personView/personsview");
    }

    @RequestMapping(value = "/detail-person/{personid}", method = RequestMethod.GET)
    public ModelAndView detailPerson(HttpServletRequest request, @PathVariable(name = "personid") int id) {
        Person person = iPersonService.getPersonByIdSevice(id);
        request.setAttribute("person", person);
        return new ModelAndView("personView/detailpersonview");
    }

    @RequestMapping(value = "/delete-person/{personid}", method = RequestMethod.GET)
    public ModelAndView deletePerson(HttpServletRequest request, @PathVariable(name = "personid") int id) {
        iPersonService.deletePersonSevice(id);
        List<Person> personList = iPersonService.getAllPersonSevice();
        request.setAttribute("persons", personList);
        return new ModelAndView("personView/personsview");
    }

    @RequestMapping(value = {"/add-person"}, method = RequestMethod.GET)
    public ModelAndView addPerson(HttpServletRequest request) {
        request.setAttribute("person", new Person());
        return new ModelAndView("personView/addpersonview");
    }

    @RequestMapping(value = {"/add-person"}, method = RequestMethod.POST)
    public String addPerson(HttpServletRequest request, @ModelAttribute("person") Person person,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "personView/addpersonview";
        }
        iPersonService.addPersonSevice(person);
        return "redirect:/list-person";
    }

    @RequestMapping(value = {"/update-person/{personid}"}, method = RequestMethod.GET)
    public ModelAndView updatePerson(HttpServletRequest request, @PathVariable(name = "personid") int personid) {
        Person person = iPersonService.getPersonByIdSevice(personid);
        request.setAttribute("person", person);
        return new ModelAndView("personView/updatepersonview");
    }

    @RequestMapping(value = {"/update-person"}, method = RequestMethod.POST)
    public String updatePerson(HttpServletRequest request, @ModelAttribute("person") Person person,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "personView/updatepersonview";
        }
        iPersonService.editPersonSevice(person);
        return "redirect:/list-person";
    }
}

