package com.tutorialspoint.dao;

import com.tutorialspoint.model.Person;

import java.util.List;

public interface IPersonDao {
    public boolean  addPerson(Person p);
    public boolean  editPerson(Person p);
    public boolean  deletePerson(int id);
    public Person  getPersonById(int id);
    public List<Person> getAllPerson();
}
