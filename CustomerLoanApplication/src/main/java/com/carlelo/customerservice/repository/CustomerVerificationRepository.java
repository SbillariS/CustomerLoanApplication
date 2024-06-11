package com.carlelo.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlelo.customerservice.model.CustomerVerification;
@Repository
public interface CustomerVerificationRepository extends JpaRepository<CustomerVerification, Integer>{


}
