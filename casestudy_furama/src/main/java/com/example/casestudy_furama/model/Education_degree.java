package com.example.casestudy_furama.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Education_degree {
    @Id
    private Long id_education_degre;
    private String nameOfEducationDegre;

    public Education_degree(Long id_education_degre, String nameOfEducationDegre) {
        this.id_education_degre = id_education_degre;
        this.nameOfEducationDegre = nameOfEducationDegre;
    }

    public Education_degree() {
    }

    public Long getId_education_degre() {
        return id_education_degre;
    }

    public void setId_education_degre(Long id_education_degre) {
        this.id_education_degre = id_education_degre;
    }

    public String getNameOfEducationDegre() {
        return nameOfEducationDegre;
    }

    public void setNameOfEducationDegre(String nameOfEducationDegre) {
        this.nameOfEducationDegre = nameOfEducationDegre;
    }
}
