package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.customerservice.servicei.LoanApplicantServiceI;

@RestController
public class loanApplicantController 
{
	@Autowired
	LoanApplicantServiceI loan;
}
