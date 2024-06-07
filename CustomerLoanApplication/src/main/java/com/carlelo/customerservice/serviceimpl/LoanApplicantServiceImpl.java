package com.carlelo.customerservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.repository.LoanApplicantRepository;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class LoanApplicantServiceImpl implements LoanApplicantServiceI
{
	@Autowired LoanApplicantRepository repo;

	@Override
	public LoanApplicant addCustomerDetails(String customerdetails) 
	{
		ObjectMapper mapper=new ObjectMapper();
		LoanApplicant app=null;
		try {
			app=mapper.readValue(customerdetails, LoanApplicant.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return repo.save(app);
	}

	@Override
	public List<LoanApplicant> GetAllApplicantDetails()
	{
		return repo.findAll();
	}

	@Override
	public LoanApplicant GetSingleApplicant(int customerId) 
	{
		Optional<LoanApplicant> optional=repo.findById(customerId);
		if(optional.isPresent())
		{
		   return optional.get();
		}
		return null;
	}

	@Override
	public List<LoanApplicant> deleteSingleApplicant(int customerId)
	{
		if(repo.existsById(customerId))
		{
		   repo.deleteById(customerId);
		   return repo.findAll();
		}
		
		return null;
	}

	@Override
	public void deleteAllApplicant() 
	{
		 repo.deleteAll();
	}
}
