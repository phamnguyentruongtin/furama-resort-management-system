package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Facility;
import com.example.casestudy_furama.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFacilityService {
    Page<Facility> findAllFacilityWithPage(String nameOfFacility,PageRequest pageRequest);
    List<Facility> listAllFacility();
    void saveFacility(Facility facility);
    void deleteFacility(Facility facility);
    Facility findFacilityByID(Long id);
    Facility findFacilityByName(String nameOfFacility);
    Page<Facility> findAllFacilityById_FacilityType(String id_facilityType,String nameOfFacility,PageRequest pageRequest);
}
