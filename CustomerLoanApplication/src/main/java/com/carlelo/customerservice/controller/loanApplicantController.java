package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.model.CustomerAddress;
import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.MedicalDetails;

import com.carlelo.customerservice.servicei.LoanApplicantServiceI;



@RestController
public class loanApplicantController 
{
	@Autowired
	LoanApplicantServiceI loan;
	


	@PostMapping("/addCustomerDetails")
	public ResponseEntity<LoanApplicant> addCustomerDetails(@RequestPart("customerJson") String customerdetails,
			                                             
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
	@PutMapping("/patchDta/{customerId}")
	public ResponseEntity <LoanApplicant> patchData(@RequestPart("text") String loanjason,
			@PathVariable int customerId,
			@RequestPart("id") MultipartFile documentid,
			@RequestPart("add") MultipartFile addressproof,
					@RequestPart("pancard") MultipartFile pancard,
					@RequestPart("tax")MultipartFile incomeTax,
							@RequestPart("adcard") MultipartFile adcardd,
							@RequestPart("photo") MultipartFile img,
							@RequestPart("signature") MultipartFile signature,
							@RequestPart("bankc") MultipartFile banqcheque,
							@RequestPart("salslip") MultipartFile salaryslip)
	{
		
	LoanApplicant la1=loan.patchData(loanjason,documentid,addressproof,pancard,incomeTax,adcardd,img,signature,banqcheque,salaryslip);
		return new ResponseEntity <LoanApplicant>( la1,HttpStatus.OK);
	}
}





