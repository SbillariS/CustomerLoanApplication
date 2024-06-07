package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;

@RestController
public class loanApplicantController 
{
	@Autowired LoanApplicantServiceI loan;
	
	@PostMapping("/addCustomerDetails")
	public ResponseEntity<LoanApplicant> addCustomerDetails(@RequestPart("customerJson") String customerdetails,
			                                               /* @RequestPart("info") String dependentinf,
			                                        
			                                                @RequestPart("accdetails") String accdetails,
			                                                @RequestPart("cibdetails") String cibildetails,
			                                                @RequestPart("addrdetails") String addressdetails,
			                                                @RequestPart("veridetails") String verificationdetails,
			                                                @RequestPart("gurantordetails") String gurantordetails,
			                                                @RequestPart("leddetails") String ledgerdetails,
			                                                @RequestPart("loandetails") String loanappdetails,
			                                                @RequestPart("disbursedetails") String disbdetails,
			                                                @RequestPart("medidetails") String medicaldetails,
			                                                @RequestPart("sanctionletter") String sanctionletter,*/
			                                                @RequestPart("address") MultipartFile profaddr,
			                                                @RequestPart("pan") MultipartFile profpan,
			                                                @RequestPart("photo") MultipartFile profphoto,
			                                                @RequestPart("it") MultipartFile profit,
			                                                @RequestPart("adhar") MultipartFile profadhar,
			                                                @RequestPart("sign") MultipartFile profsign,
			                                                @RequestPart("checque") MultipartFile profchecque,
			                                                @RequestPart("sslip") MultipartFile profsslip)
	{                         
		LoanApplicant la=loan.addCustomerDetails(customerdetails,profaddr,profpan,profphoto,profit,profadhar,profsign,profchecque,profsslip);
		return new ResponseEntity<LoanApplicant>(la,HttpStatus.CREATED);	
	}
}
