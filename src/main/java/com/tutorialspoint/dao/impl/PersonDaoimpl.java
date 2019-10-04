package com.tutorialspoint.dao.impl;

import com.tutorialspoint.dao.IPersonDao;
import com.tutorialspoint.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDaoimpl implements IPersonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addPerson(Person p) {
        String sql = "INSERT INTO PERSON(NAME,GENDER) VALUE(?,?)";
        jdbcTemplate.update(sql, p.getName(), p.getAge());
        return true;
    }

    @Override
    public boolean editPerson(Person p) {
        String sql = "UPDATE  PERSON SET NAME=? AND GENDER=? WHERE ID=?";
        jdbcTemplate.update(sql, p.getName(), p.getAge(), p.getId());
        return true;
    }

    @Override
    public boolean deletePerson(int id) {
        String sql = "DELETE FROM  PERSON  WHERE ID=?";
        jdbcTemplate.update(sql, id);
        return true;
    }

    @Override
    public Person getPersonById(int id) {
        String sql = "SELECT * FROM  PERSON  WHERE ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setGender(resultSet.getString("gender"));
                return person;
            }
        });
    }

    @Override
    public List<Person> getAllPerson() {
        String sql = "SELECT * FROM  PERSON";
        return jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setGender(resultSet.getString("gender"));
                return person;
            }
        });
    }
}
