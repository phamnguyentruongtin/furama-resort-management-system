package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface IContractService {
    void saveContract(Contract contract);
    void deleteContract(Contract contract);
    Page<Contract> contractWithPage(String nameCustomer,PageRequest pageRequest);
    Contract findContractById(Long id_contract);

}
