package com.creditapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;


@Entity
@JsonPropertyOrder({"id", "firstName", "lastName", "dateOfBirth","resStatus"})
public class Application {

    public Application(String firstName, String lastName, Date dateOfBirth, String resStatus, Double income, String empStatus, int noOfDependants, int addressYears, int addressMonths, Double creditLimit) {
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        this.resStatus = resStatus;
        this.income = income;
        this.empStatus = empStatus;
        this.noOfDependants = noOfDependants;
        this.addressYears = addressYears;
        this.addressMonths = addressMonths;
        this.creditLimit = creditLimit;
    }

    public void setId(int id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;


//    public Application(String firstName, String lastName, Date dateOfBirth) {
//        FirstName = firstName;
//        LastName = lastName;
//        DateOfBirth = dateOfBirth;
//
//    }

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

    private String resStatus;

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public int getNoOfDependants() {
        return noOfDependants;
    }

    public void setNoOfDependants(int noOfDependants) {
        this.noOfDependants = noOfDependants;
    }

    public int getAddressYears() {
        return addressYears;
    }

    public void setAddressYears(int addressYears) {
        this.addressYears = addressYears;
    }

    public int getAddressMonths() {
        return addressMonths;
    }

    public void setAddressMonths(int addressMonths) {
        this.addressMonths = addressMonths;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    private Double income;

    private String empStatus;

    private int noOfDependants;

    private int addressYears;

    private int addressMonths;

    private Double creditLimit;

}
