package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Division;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDivisionService {
    List<Division> divisionList();
}
