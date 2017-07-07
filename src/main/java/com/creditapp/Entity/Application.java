package com.creditapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;


@Entity
@JsonPropertyOrder({"id", "firstName", "lastName", "dateOfBirth"})
public class Application {

    public void setId(int id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;


    public Application(String firstName, String lastName, Date dateOfBirth) {
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;

    }

    public Application() {
    }

    @JsonIgnore
    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
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

    public Date DateOfBirth;
}
