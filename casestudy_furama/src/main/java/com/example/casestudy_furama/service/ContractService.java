package com.example.casestudy_furama.service;

import com.example.casestudy_furama.model.Contract;
import com.example.casestudy_furama.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ContractService implements IContractService{
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public void saveContract(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void deleteContract(Contract contract) {
        iContractRepository.delete(contract);
    }

    @Override
    public Page<Contract> contractWithPage(String nameCustomer,PageRequest pageRequest) {
       return iContractRepository.findALlContractWithPage(nameCustomer,pageRequest);
    }

    @Override
    public Contract findContractById(Long id_contract) {
        return iContractRepository.findById(id_contract).orElseThrow(() -> new IllegalArgumentException("Not found!!!"));
    }
}
