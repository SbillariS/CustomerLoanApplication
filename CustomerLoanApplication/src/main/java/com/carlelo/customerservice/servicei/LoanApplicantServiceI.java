package com.carlelo.customerservice.servicei;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.model.LoanApplicant;

public interface LoanApplicantServiceI 
{
	
	public LoanApplicant addCustomerDetails(String customerdetails,MultipartFile profaddr, MultipartFile profpan, MultipartFile profphoto, MultipartFile profit, MultipartFile profadhar, MultipartFile profsign, MultipartFile profchecque, MultipartFile profsslip);

	public List<LoanApplicant> GetAllApplicantDetails();

	public LoanApplicant GetSingleApplicant(int customerId);

	public List<LoanApplicant> deleteSingleApplicant(int customerId);

	public void deleteAllApplicant();



}
