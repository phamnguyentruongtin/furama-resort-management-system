package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Customer;
import com.example.casestudy_furama.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomerWithPage(String nameCustomer,String dateOfBirth,String phoneNumber, PageRequest pageRequest) {
        return iCustomerRepository.findAllCustomerWithPage(nameCustomer,dateOfBirth,phoneNumber, pageRequest);
    }

    @Override
    public void saveCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByName(String nameCustomer) {
        return iCustomerRepository.findCustomerBynameCustomer(nameCustomer);

    }

    @Override
    public void deleteCustomer(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public List<Customer> listAllCustomers() {
        return iCustomerRepository.findAll();
    }

}
