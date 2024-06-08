package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
import com.carlelo.enquiry.model.CibilDetails;
import com.carlelo.enquiry.model.EnquiryDetails;

@RestController
public class loanApplicantController 
{
	@Autowired LoanApplicantServiceI loan;
	@Autowired RestTemplate rs;
	
	@PostMapping("/addCustomerDetails")
	public ResponseEntity<LoanApplicant> addCustomerDetails(@RequestPart("customerJson") String customerdetails,
			                                                @RequestPart("address") MultipartFile profaddr,
			                                                @RequestPart("pan") MultipartFile profpan,
			                                                @RequestPart("photo") MultipartFile profphoto,
			                                                @RequestPart("it") MultipartFile profit,
			                                                @RequestPart("adhar") MultipartFile profadhar,
			                                                @RequestPart("sign") MultipartFile profsign,
			                                                @RequestPart("checque") MultipartFile profchecque,
			                                                @RequestPart("sslip") MultipartFile profsslip
			                                                @PathVariable String)
	{      
		   String url="http://localhost:9081/getcibilDetails";
	       CibilDetails cd=rs.getForObject(url,CibilDetails.class);                   
		   LoanApplicant la=loan.addCustomerDetails(customerdetails,profaddr,profpan,profphoto,profit,profadhar,profsign,profchecque,profsslip);
		return new ResponseEntity<LoanApplicant>(la,HttpStatus.CREATED);	
	}
}
