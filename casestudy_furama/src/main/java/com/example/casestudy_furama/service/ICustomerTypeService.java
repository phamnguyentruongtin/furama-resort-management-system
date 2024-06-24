package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();
}
