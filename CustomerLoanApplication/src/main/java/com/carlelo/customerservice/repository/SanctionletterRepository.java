package com.carlelo.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.customerservice.model.SanctionLetter;

@Repository
public interface SanctionletterRepository extends JpaRepository<SanctionLetter, Integer> {

}
