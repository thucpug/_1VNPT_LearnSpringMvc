package com.tutorialspoint.model;

public class Order {
    private Person person;

    public Order(Person person) {
        super();
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
