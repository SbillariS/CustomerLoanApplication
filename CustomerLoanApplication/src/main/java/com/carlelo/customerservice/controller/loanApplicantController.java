package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.customerservice.model.CustomerAddress;
import com.carlelo.customerservice.model.MedicalDetails;
import com.carlelo.customerservice.servicei.CustomerAddressServiceI;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
import com.carlelo.customerservice.servicei.MedicalDetailsServiceI;


@RestController
public class loanApplicantController 
{
	@Autowired
	LoanApplicantServiceI loan;
	
	@Autowired
	MedicalDetailsServiceI mds;
	
	@Autowired
	CustomerAddressServiceI customeradrr;
	
	@PostMapping("/addMedical")
	public ResponseEntity<MedicalDetails> saveMedicalDetails(@RequestBody MedicalDetails md)
	{
		MedicalDetails md1=mds.saveMedicalDetails();
		
		return new ResponseEntity<MedicalDetails>(md1,HttpStatus.CREATED);
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<CustomerAddress> saveCustomerAddress(@RequestBody CustomerAddress cad)
	{
		CustomerAddress cad1 =customeradrr.saveCustomerAddress();
		
		return new ResponseEntity<CustomerAddress>(cad1,HttpStatus.CREATED);
	}
}
