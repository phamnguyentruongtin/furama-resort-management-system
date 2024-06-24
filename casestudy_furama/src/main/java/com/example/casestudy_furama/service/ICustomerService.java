package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {
    Page<Customer> findAllCustomerWithPage(String nameCustomer,String dateOfBirth,String phoneNumber, PageRequest pageRequest);
    void saveCustomer(Customer customer);
    Customer findCustomerByName(String nameCustomer);
    void deleteCustomer(Customer customer);
    List<Customer> listAllCustomers();
}
