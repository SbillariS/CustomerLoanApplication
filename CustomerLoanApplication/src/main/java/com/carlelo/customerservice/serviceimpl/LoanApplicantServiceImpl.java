package com.carlelo.customerservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.customerservice.repository.LoanApplicantRepository;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
@Service
public class LoanApplicantServiceImpl implements LoanApplicantServiceI
{
	@Autowired
	LoanApplicantRepository repo;
}
