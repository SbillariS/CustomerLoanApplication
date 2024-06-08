package com.carlelo.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.customerservice.model.LoanApplicant;
@Repository
public interface LoanApplicantRepository extends JpaRepository<LoanApplicant, Integer>{

	

	

}
