package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Division;
import com.example.casestudy_furama.repository.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService{
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> divisionList() {
        return iDivisionRepository.findAll();
    }
}
