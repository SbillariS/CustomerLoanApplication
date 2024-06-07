package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;

@RestController
public class loanApplicantController 
{
	@Autowired 
	LoanApplicantServiceI loan;
	
	@PostMapping("/addCustomerDetails")
	public ResponseEntity<LoanApplicant> addCustomerDetails(@RequestPart("customerJson") String customerdetails)
	{
		LoanApplicant la=loan.addCustomerDetails(customerdetails);
		return new ResponseEntity<LoanApplicant>(la,HttpStatus.CREATED);	
	}
}
