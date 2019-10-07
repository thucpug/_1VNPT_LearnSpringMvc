package com.tutorialspoint.dao;

import com.tutorialspoint.entity.PersonEntity;

import java.util.List;

public interface IPersonDao {
    public boolean  addPerson(PersonEntity p);
    public boolean  editPerson(PersonEntity p);
    public boolean  deletePerson(int id);
    public PersonEntity  getPersonById(int id);
    public List<PersonEntity> getAllPerson();
}
