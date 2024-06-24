package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Facility;
import com.example.casestudy_furama.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAllFacilityWithPage(String nameOfFacility,PageRequest pageRequest) {
        return facilityRepository.findAllFacilityWithPage(nameOfFacility,pageRequest);
    }

    @Override
    public List<Facility> listAllFacility() {
        return facilityRepository.findAll();
    }

    @Override
    public void saveFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void deleteFacility(Facility facility) {
        facilityRepository.delete(facility);
    }

    @Override
    public Facility findFacilityByID(Long id) {
        return facilityRepository.findFacilityByIdById(id);
    }

    @Override
    public Facility findFacilityByName(String nameOfFacility) {
        return facilityRepository.findFacilityBynameOfFacility(nameOfFacility);
    }

    @Override
    public Page<Facility> findAllFacilityById_FacilityType(String id_facilityType,String nameOfFacility, PageRequest pageRequest) {
        return facilityRepository.findFacilityByRentTypeType(id_facilityType,nameOfFacility,pageRequest);
    }


}
