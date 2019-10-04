package com.tutorialspoint.service.impl;

import com.tutorialspoint.dao.impl.PersonDaoimpl;
import com.tutorialspoint.model.Person;
import com.tutorialspoint.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    public PersonDaoimpl personDaoimpl;

    @Override
    public void addPersonSevice(Person p) {
        personDaoimpl.addPerson(p);
    }

    @Override
    public void editPersonSevice(Person p) {
        personDaoimpl.editPerson(p);
    }

    @Override
    public void deletePersonSevice(int id) {
        personDaoimpl.deletePerson(id);
    }

    @Override
    public void getPersonByIdSevice(int id) {
        personDaoimpl.getPersonById(id);
    }

    @Override
    public List<Person> getAllPersonSevice() {
       return personDaoimpl.getAllPerson();
    }
}
