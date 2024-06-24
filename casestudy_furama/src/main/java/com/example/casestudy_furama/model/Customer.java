package com.example.casestudy_furama.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idCustomer;
    @NotEmpty(message = "Không Được Rỗng !!!")
    private String nameCustomer;
//    @Pattern(regexp = "^(19[7-9][0-9]|20[0-2][0-9])-([0][1-9]|[1][0-2])-([0-2][1-9]|[3][0-1])$\n",message = "Sai Định Dạng !!!")
    private String dayOfBirth;
    @NotEmpty(message = "Không Được Rỗng !!!")
    private String gender;

    @Pattern(regexp = "^[0-9]{9,12}$",message = "Sai Định Dạng !!!")
    private String id_card;
    @Pattern(regexp = "^(0|\\+84)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8]|9[0-4|6-9])[0-9]{7}$",message = "Sai Định Dạng !!!")
    private String phoneNumber;
    @Email(message = "Sai Định Dạng !!!")
    private String email;
    @NotEmpty(message = "Không Được Rỗng !!!")
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    CustomerType customerType;

    public Customer(Long idCustomer, String nameCustomer, String dayOfBirth, String gender, String id_card, String phoneNumber, String email, String address, CustomerType customerType) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.id_card = id_card;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Customer() {
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
