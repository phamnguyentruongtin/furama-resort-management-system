package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRentTypeService {
    List<RentType> rentTypeList();
}
