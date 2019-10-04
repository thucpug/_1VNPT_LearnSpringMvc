package com.tutorialspoint.model;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Person {

    private int id;
    @NotEmpty
    @Length(min = 10, max = 16)
    private String name;
    @Min(1)
    private int age;
    private List<String> listFavorite;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getListFavorite() {
        return listFavorite;
    }

    public void setListFavorite(List<String> listFavorite) {
        this.listFavorite = listFavorite;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void init() {
        System.out.println("Init Person");
    }

    public void destroy() {
        System.out.println("Destroy Person");
    }
}
