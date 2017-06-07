package com.creditapp.Entity;

import javax.persistence.*;


@Entity
public class Application {

    public void setId(int id) {
        Id = id;
    }

    @Id
    private int Id;

    public Application(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public Application() {
    }

    public int getId() {
        return Id;
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    private String FirstName;

    private String LastName;
}
