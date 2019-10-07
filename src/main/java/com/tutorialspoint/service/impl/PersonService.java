package com.tutorialspoint.service.impl;

import com.sun.org.apache.xpath.internal.objects.XObject;
import com.tutorialspoint.dao.IPersonDao;
import com.tutorialspoint.dao.impl.PersonDaoimpl;
import com.tutorialspoint.entity.PersonEntity;
import com.tutorialspoint.model.Person;
import com.tutorialspoint.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    public IPersonDao iPersonDao;

    @Override
    public void addPersonSevice(Person p) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(p.getName());
        personEntity.setGender(p.getGender());
        iPersonDao.addPerson(personEntity);
    }

    @Override
    public void editPersonSevice(Person p) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(p.getId());
        personEntity.setName(p.getName());
        personEntity.setGender(p.getGender());
        iPersonDao.editPerson(personEntity);
    }

    @Override
    public void deletePersonSevice(int id) {

        iPersonDao.deletePerson(id);
    }

    @Override
    public Person getPersonByIdSevice(int id) {
        PersonEntity temp = iPersonDao.getPersonById(id);
        Person p = new Person();
        p.setId(temp.getId());
        p.setName(temp.getName());
        p.setGender(temp.getGender());
        return p;
    }

    @Override
    public List<Person> getAllPersonSevice() {
        List<PersonEntity> personEntities = iPersonDao.getAllPerson();
        List<Person> personList = new ArrayList<Person>();
        for (PersonEntity temp : personEntities) {
            Person p = new Person();
            p.setId(temp.getId());
            p.setName(temp.getName());
            p.setGender(temp.getGender());
            personList.add(p);
        }
        return personList;
    }
}
