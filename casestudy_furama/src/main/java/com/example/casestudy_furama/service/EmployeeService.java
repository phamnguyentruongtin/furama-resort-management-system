package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Employee;
import com.example.casestudy_furama.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public void saveEmployee(Employee employe) {
        iEmployeeRepository.save(employe);
    }

    @Override
    public void deleteEmployee(Employee employe) {
        iEmployeeRepository.delete(employe);
    }

    @Override
    public Employee findEmployeeByName(String nameEmployee) {
        return iEmployeeRepository.findEmployeeBynameEmployee(nameEmployee);
    }

    @Override
    public Page<Employee> findAllEmployeesWithPage(String nameEmployee, PageRequest pageRequest) {
        return iEmployeeRepository.findAllEmployeeOrfindByName(nameEmployee,pageRequest);
    }

    @Override
    public List<Employee> employeList() {
        return iEmployeeRepository.findAll();
    }
}
