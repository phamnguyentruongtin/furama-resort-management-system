package com.example.casestudy_furama.repository;

import com.example.casestudy_furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query(value = "select * from contract co,customer cu where co.customer_id_customer = id_customer and cu.name_customer like %?1%",nativeQuery = true)
    Page<Contract> findALlContractWithPage(String nameCustomer,PageRequest pageRequest);

    Contract findContractByidContract(Long id_contract);
}
