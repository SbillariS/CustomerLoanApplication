package com.carlelo.customerservice.servicei;

import java.util.List;

import com.carlelo.customerservice.model.LoanApplicant;

public interface LoanApplicantServiceI 
{
	
	public LoanApplicant addCustomerDetails(String customerdetails);

	public List<LoanApplicant> GetAllApplicantDetails();

	public LoanApplicant GetSingleApplicant(int customerId);

	public List<LoanApplicant> deleteSingleApplicant(int customerId);

	public void deleteAllApplicant();



}
