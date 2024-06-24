package com.example.casestudy_furama.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacilityType;
    private String nameOfFacilityType;
    private String img;

    public FacilityType(Long idFacilityType, String nameOfFacilityType, String img) {
        this.idFacilityType = idFacilityType;
        this.nameOfFacilityType = nameOfFacilityType;
        this.img = img;
    }

    public Long getIdFacilityType() {
        return idFacilityType;
    }

    public void setIdFacilityType(Long idFacilityType) {
        this.idFacilityType = idFacilityType;
    }

    public String getNameOfFacilityType() {
        return nameOfFacilityType;
    }

    public void setNameOfFacilityType(String nameOfFacilityType) {
        this.nameOfFacilityType = nameOfFacilityType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public FacilityType() {
    }
}
