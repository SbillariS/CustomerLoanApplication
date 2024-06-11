package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.SanctionLetter;
import com.carlelo.customerservice.servicei.SanctionletteServiceI;

@RestController
public class SanctionletterController {
	
	@Autowired
	SanctionletteServiceI ss;
	
	@PutMapping("updateSanctionlette/{customerId}")
	public ResponseEntity<LoanApplicant> updateSanction(@RequestBody SanctionLetter sl,@PathVariable int customerId )
	{
		LoanApplicant xz=ss.updateSanction(sl,customerId);
				return new ResponseEntity<LoanApplicant>(xz, HttpStatus.ACCEPTED);
	}

}
