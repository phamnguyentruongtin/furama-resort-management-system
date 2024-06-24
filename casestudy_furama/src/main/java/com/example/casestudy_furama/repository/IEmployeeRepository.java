package com.example.casestudy_furama.repository;

import com.example.casestudy_furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee where name_employee like %?1%", nativeQuery = true)
    Page<Employee> findAllEmployeeOrfindByName(String nameEmployee, PageRequest pageRequest);

    Employee findEmployeeBynameEmployee(String nameEmployee);
}
