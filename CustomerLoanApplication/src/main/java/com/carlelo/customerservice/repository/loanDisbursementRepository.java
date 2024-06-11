package com.carlelo.customerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.customerservice.model.LoanDisbursement;
@Repository
public interface loanDisbursementRepository extends CrudRepository<LoanDisbursement,Integer>{

}
