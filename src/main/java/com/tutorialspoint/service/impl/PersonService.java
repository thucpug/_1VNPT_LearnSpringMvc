package com.tutorialspoint.service.impl;

import com.tutorialspoint.dao.IPersonDao;
import com.tutorialspoint.dao.impl.PersonDaoimpl;
import com.tutorialspoint.model.Person;
import com.tutorialspoint.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    public IPersonDao iPersonDao;

    @Override
    public void addPersonSevice(Person p) {
        iPersonDao.addPerson(p);
    }

    @Override
    public void editPersonSevice(Person p) {
        iPersonDao.editPerson(p);
    }

    @Override
    public void deletePersonSevice(int id) {
        iPersonDao.deletePerson(id);
    }

    @Override
    public Person getPersonByIdSevice(int id) {
       return iPersonDao.getPersonById(id);
    }

    @Override
    public List<Person> getAllPersonSevice() {
       return iPersonDao.getAllPerson();
    }
}
