package com.example.casestudy_furama.model;

import javax.persistence.*;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOfFacility;
    private String nameOfFacility;
    private Integer area;
    private Double cost;
    private String img;
    private Integer max_people;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String standardRoom;
    private Integer numberOfFloor;
    private String description_other_convenience;
    private Double poolArea;
    private String facilityFree;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private RentType rentType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private FacilityType facilityType;


    public Facility() {
    }

    public Facility(Long idOfFacility, String nameOfFacility, Integer area, Double cost, String img, Integer max_people, String standardRoom, Integer numberOfFloor, String description_other_convenience, Double poolArea, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.idOfFacility = idOfFacility;
        this.nameOfFacility = nameOfFacility;
        this.area = area;
        this.cost = cost;
        this.img = img;
        this.max_people = max_people;
        this.standardRoom = standardRoom;
        this.numberOfFloor = numberOfFloor;
        this.description_other_convenience = description_other_convenience;
        this.poolArea = poolArea;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public Long getIdOfFacility() {
        return idOfFacility;
    }

    public void setIdOfFacility(Long idOfFacility) {
        this.idOfFacility = idOfFacility;
    }

    public String getNameOfFacility() {
        return nameOfFacility;
    }

    public void setNameOfFacility(String nameOfFacility) {
        this.nameOfFacility = nameOfFacility;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMax_people() {
        return max_people;
    }

    public void setMax_people(Integer max_people) {
        this.max_people = max_people;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }
}
