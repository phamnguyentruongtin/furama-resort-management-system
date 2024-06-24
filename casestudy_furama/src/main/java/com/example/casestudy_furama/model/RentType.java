package com.example.casestudy_furama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRentType;
    private String nameOfRentType;

    public RentType() {
    }

    public RentType(Long idRentType, String nameOfRentType) {
        this.idRentType = idRentType;
        this.nameOfRentType = nameOfRentType;
    }

    public Long getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(Long idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameOfRentType() {
        return nameOfRentType;
    }

    public void setNameOfRentType(String nameOfRentType) {
        this.nameOfRentType = nameOfRentType;
    }
}
