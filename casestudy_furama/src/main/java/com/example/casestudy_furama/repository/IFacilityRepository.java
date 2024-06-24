package com.example.casestudy_furama.repository;

import com.example.casestudy_furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Long> {
    @Query(value = "select * from facility where name_of_facility like %?1%",nativeQuery = true)
    Page<Facility> findAllFacilityWithPage(String nameOfFacility, PageRequest pageRequest);
    Facility findFacilityBynameOfFacility(String nameOfFacility);
    @Query(value ="select * from facility where id_of_facility = ?1" ,nativeQuery = true)
    Facility findFacilityByIdById(Long id);
    @Query(value = "select * from facility where facility_type_id_facility_type like %?1% and name_of_facility like %?2% ",nativeQuery = true)
    Page<Facility> findFacilityByRentTypeType(String id_FacilityType,String nameFacility,PageRequest pageRequest);
}
