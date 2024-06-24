package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Education_degree;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEducation_degreeService {
    List<Education_degree> education_degreList();
}
