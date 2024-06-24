package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Employee;
import com.example.casestudy_furama.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
        void saveEmployee(Employee employe);
        void deleteEmployee(Employee employe);
        Employee findEmployeeByName(String nameEmployee);
        Page<Employee> findAllEmployeesWithPage(String nameEmployee, PageRequest pageRequest);
        List<Employee> employeList();
}
