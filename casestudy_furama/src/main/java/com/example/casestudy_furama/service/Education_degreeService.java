package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Education_degree;
import com.example.casestudy_furama.repository.IEducation_degreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Education_degreeService implements IEducation_degreeService{
    @Autowired
    IEducation_degreeRepository iEducation_degreeRepository;
    @Override
    public List<Education_degree> education_degreList() {
        return iEducation_degreeRepository.findAll();
    }
}
