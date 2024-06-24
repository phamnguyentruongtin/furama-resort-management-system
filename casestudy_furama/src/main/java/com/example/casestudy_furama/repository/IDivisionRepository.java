package com.example.casestudy_furama.repository;

import com.example.casestudy_furama.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface IDivisionRepository extends JpaRepository<Division,Long> {
}
