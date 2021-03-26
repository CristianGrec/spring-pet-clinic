package com.springtraining.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Person() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "Person(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ")";
    }
}
