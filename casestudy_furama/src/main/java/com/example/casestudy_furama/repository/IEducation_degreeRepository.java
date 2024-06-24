package com.example.casestudy_furama.repository;

import com.example.casestudy_furama.model.Education_degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducation_degreeRepository extends JpaRepository<Education_degree,Long> {

}
