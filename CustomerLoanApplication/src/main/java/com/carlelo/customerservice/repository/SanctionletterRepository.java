package com.carlelo.customerservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.SanctionLetter;

@Repository
public interface SanctionletterRepository extends JpaRepository<SanctionLetter, Integer> 
{

public LoanApplicant save(LoanApplicant la);

public Optional<LoanApplicant> findBycustomerId(int customerId);

}
