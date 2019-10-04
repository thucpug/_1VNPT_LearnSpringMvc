package com.tutorialspoint.service;

import com.tutorialspoint.model.Person;

import java.util.List;

public interface IPersonService {
    public void addPersonSevice(Person p);
    public void editPersonSevice(Person p);
    public void deletePersonSevice(int id);
    public void getPersonByIdSevice(int id);
    public List<Person> getAllPersonSevice();

}
