package com.carlelo.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.model.CibilDetails;
import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;

@RestController
public class loanApplicantController 
{
	@Autowired LoanApplicantServiceI loan;
	@Autowired RestTemplate rt;
	
	@PostMapping("/addCustomerDetails/{enquiryId}")
	public ResponseEntity<LoanApplicant> addCustomerDetails(@RequestPart("customerJson") String customerdetails,
			                                                @RequestPart("address") MultipartFile profaddr,
			                                                @RequestPart("pan") MultipartFile profpan,
			                                                @RequestPart("photo") MultipartFile profphoto,
			                                                @RequestPart("it") MultipartFile profit,
			                                                @RequestPart("adhar") MultipartFile profadhar,
			                                                @RequestPart("sign") MultipartFile profsign,
			                                                @RequestPart("checque") MultipartFile profchecque,
			                                                @RequestPart("sslip") MultipartFile profsslip,
			                                                @PathVariable String enquiryId)
	{      
		String url="http://localhost:9080/getcibilDetails/"+enquiryId;
		CibilDetails cd=rt.getForObject(url, CibilDetails.class);
		LoanApplicant la=loan.addCustomerDetails(customerdetails,profaddr,profpan,profphoto,profit,profadhar,profsign,profchecque,profsslip,enquiryId,cd);
		return new ResponseEntity<LoanApplicant>(la,HttpStatus.CREATED);	
	}
	
	@GetMapping("/AllApplicant")
	public ResponseEntity<List<LoanApplicant>> GetAllApplicantDetails()
	{
		List<LoanApplicant> applicantList=loan.GetAllApplicantDetails();
		return new ResponseEntity<List<LoanApplicant>>(applicantList,HttpStatus.OK);	
	}
	
	@GetMapping("/getSingleApplicant")
	public ResponseEntity<LoanApplicant> GetSingleApplicant(@PathVariable int customerId)
	{
		LoanApplicant applicant=loan.GetSingleApplicant(customerId);
		return new ResponseEntity<LoanApplicant>(applicant,HttpStatus.OK);	
	}
	
	@DeleteMapping("/deleteSingleApplicant")
	public ResponseEntity<List<LoanApplicant>> deleteSingleApplicant(@PathVariable int customerId)
	{
		List<LoanApplicant> applicant=loan.deleteSingleApplicant(customerId);
		return new ResponseEntity<List<LoanApplicant>>(applicant,HttpStatus.OK);	
	}
	@DeleteMapping("/deleteAllApplicant")
	public ResponseEntity<String> deleteAllApplicant()
	{
		loan.deleteAllApplicant();
		String str="All applicant deleted successfully";
		return new ResponseEntity<String>(str,HttpStatus.OK);	
	}
}
