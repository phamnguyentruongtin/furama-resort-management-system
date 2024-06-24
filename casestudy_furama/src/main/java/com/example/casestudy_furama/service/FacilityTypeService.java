package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.FacilityType;
import com.example.casestudy_furama.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> facilityTypeList() {
        return iFacilityTypeRepository.findAll();
    }
}
