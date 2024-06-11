package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.LoanDisbursement;
import com.carlelo.customerservice.servicei.LoanDisbursementServiceI;
@RestController
public class loanDisbursementController
{
	@Autowired
	LoanDisbursementServiceI ldi;
	
	@PutMapping("/put/{agreeID}")
	public ResponseEntity <LoanDisbursement> saveData(@RequestBody LoanDisbursement ld,@PathVariable int agreeID )
	
	{
		LoanDisbursement ld1= ldi.saveData(ld,agreeID);
	
		return new ResponseEntity <LoanDisbursement>( ld1,HttpStatus.OK);
	}
}
