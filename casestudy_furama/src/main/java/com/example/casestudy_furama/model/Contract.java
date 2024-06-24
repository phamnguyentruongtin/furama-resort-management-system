package com.example.casestudy_furama.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;
    @NotEmpty
    private String startDay;
    @NotEmpty
    private String endDay;
    @Min(10000)
    private Double deposit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Facility facility;

    public Contract(Long idContract, String startDay, String endDay, Double deposit, Customer customer, Employee employee, Facility facility) {
        this.idContract = idContract;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
    }

    public Contract() {
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
