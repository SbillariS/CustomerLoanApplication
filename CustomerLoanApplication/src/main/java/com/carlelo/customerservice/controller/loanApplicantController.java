package com.carlelo.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.carlelo.customerservice.model.CustomerAddress;
import com.carlelo.customerservice.model.CibilDetails;
import com.carlelo.customerservice.model.CustomerVerification;
import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.MedicalDetails;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
@CrossOrigin("*")
@RestController
public class loanApplicantController 
{

	@Autowired
	LoanApplicantServiceI loan;
	@Autowired RestTemplate rt;

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
			                                               )
	{      
		
		
		LoanApplicant la=loan.addCustomerDetails(customerdetails,profaddr,profpan,profphoto,profit,profadhar,profsign,profchecque,profsslip);
		return new ResponseEntity<LoanApplicant>(la,HttpStatus.CREATED);	

	}
	@PatchMapping("/patchDta/{customerId}")
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
	

	@PutMapping("/updateCustomerDetails/{customerId}")
	public ResponseEntity<LoanApplicant> updateEnquiry(@RequestPart("customerJson") String customerdetails, @RequestPart("address") MultipartFile profaddr,@RequestPart("pan") MultipartFile profpan, @RequestPart("photo") MultipartFile profphoto,
                                                       @RequestPart("it") MultipartFile profit,@RequestPart("adhar") MultipartFile profadhar,
                                                       @RequestPart("sign") MultipartFile profsign, @RequestPart("checque") MultipartFile profchecque,
                                                       @RequestPart("sslip") MultipartFile profsslip,
                                                       @PathVariable int customerId){
		
		LoanApplicant edd=loan.updateLoanApplicant(customerdetails,profaddr,profpan,profphoto,profit,profadhar,profsign,profchecque,profsslip);
		
		return new ResponseEntity<LoanApplicant>(edd,HttpStatus.OK);
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
	@PatchMapping("/VerifyLoanApplication/{customerId}")
	public ResponseEntity<CustomerVerification> VerifyLoanApplication(@PathVariable int customerId,@RequestBody CustomerVerification cv)
	{
		CustomerVerification vefification=loan.VerifyLoanApplication(customerId,cv); 
		return new ResponseEntity<CustomerVerification>(vefification,HttpStatus.OK);	
	}
}
