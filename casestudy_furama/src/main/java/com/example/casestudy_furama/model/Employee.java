package com.example.casestudy_furama.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    @NotEmpty
    private String nameEmployee;
    @NotEmpty
    private String dateOfBirthEm;
    @NotEmpty
    private String id_cardEm;
    @Min(10000000)
    private Double salary;
    @NotEmpty
    private String phoneNumberEmployee;
    @Email
    private String emailEmployee;
    @NotEmpty
    private String addressEmployee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Education_degree education_degree;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Division division;

    public Employee(Long idEmployee, String nameEmployee, String dateOfBirthEm, String id_cardEm, Double salary, String phoneNumberEmployee, String emailEmployee, String addressEmployee, Position position, Education_degree education_degree, Division division) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dateOfBirthEm = dateOfBirthEm;
        this.id_cardEm = id_cardEm;
        this.salary = salary;
        this.phoneNumberEmployee = phoneNumberEmployee;
        this.emailEmployee = emailEmployee;
        this.addressEmployee = addressEmployee;
        this.position = position;
        this.education_degree = education_degree;
        this.division = division;
    }

    public Employee() {
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateOfBirthEm() {
        return dateOfBirthEm;
    }

    public void setDateOfBirthEm(String dateOfBirthEm) {
        this.dateOfBirthEm = dateOfBirthEm;
    }

    public String getId_cardEm() {
        return id_cardEm;
    }

    public void setId_cardEm(String id_cardEm) {
        this.id_cardEm = id_cardEm;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumberEmployee() {
        return phoneNumberEmployee;
    }

    public void setPhoneNumberEmployee(String phoneNumberEmployee) {
        this.phoneNumberEmployee = phoneNumberEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education_degree getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(Education_degree education_degree) {
        this.education_degree = education_degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
