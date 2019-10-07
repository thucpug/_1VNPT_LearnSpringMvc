package com.tutorialspoint.entity;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 *
 */
@Entity(name = "PERSON")
public class PersonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String gender;

    private String name;

    public PersonEntity() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}