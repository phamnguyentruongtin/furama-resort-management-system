package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.RentType;
import com.example.casestudy_furama.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService{
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> rentTypeList() {
        return iRentTypeRepository.findAll();
    }
}
