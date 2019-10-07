package com.tutorialspoint.dao.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tutorialspoint.dao.IPersonDao;
import com.tutorialspoint.entity.PersonEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PersonDaoimpl implements IPersonDao {
    //    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addPerson(PersonEntity p) {
        Session session ;//= this.sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean editPerson(PersonEntity p) {
        Session session ;//= this.sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deletePerson(int id) {
        Session session ;//= this.sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        PersonEntity temp =getPersonById(id);
        session.beginTransaction();
        session.delete(temp);//remove(temp);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public PersonEntity getPersonById(int id) {
        Session session ;//= this.sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.get(PersonEntity.class, id);

    }

    @Override
    public List<PersonEntity> getAllPerson() {
        Session session ;//= this.sessionFactory.getCurrentSession();
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createQuery("FROM PERSON", PersonEntity.class).getResultList();

    }
}
