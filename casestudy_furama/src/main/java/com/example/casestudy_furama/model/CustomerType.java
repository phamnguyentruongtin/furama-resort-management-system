package com.example.casestudy_furama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_of_customerType;
    private String nameOfCustomerType;

    public CustomerType(Long id_of_customerType, String nameOfCustomerType) {
        this.id_of_customerType = id_of_customerType;
        this.nameOfCustomerType = nameOfCustomerType;
    }

    public CustomerType() {
    }

    public Long getId_of_customerType() {
        return id_of_customerType;
    }

    public void setId_of_customerType(Long id_of_customerType) {
        this.id_of_customerType = id_of_customerType;
    }

    public String getNameOfCustomerType() {
        return nameOfCustomerType;
    }

    public void setNameOfCustomerType(String nameOfCustomerType) {
        this.nameOfCustomerType = nameOfCustomerType;
    }
}
