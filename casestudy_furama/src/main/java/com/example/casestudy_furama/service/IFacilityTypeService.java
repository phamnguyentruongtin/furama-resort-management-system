package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.FacilityType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFacilityTypeService {
    List<FacilityType> facilityTypeList();
}
