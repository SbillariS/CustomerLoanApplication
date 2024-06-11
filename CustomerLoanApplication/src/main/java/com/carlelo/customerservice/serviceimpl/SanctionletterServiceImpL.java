package com.carlelo.customerservice.serviceimpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.customerservice.exception.LoanApplicationNotFoundException;
import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.SanctionLetter;
import com.carlelo.customerservice.repository.LoanApplicantRepository;
import com.carlelo.customerservice.repository.SanctionletterRepository;
import com.carlelo.customerservice.servicei.SanctionletteServiceI;

@Service
public class SanctionletterServiceImpL implements SanctionletteServiceI{

	@Autowired
	SanctionletterRepository slr;
	
	@Autowired LoanApplicantRepository repo;
	
	
	@Override
	public LoanApplicant updateSanction(SanctionLetter sl, int customerId) 
	{
		Optional<LoanApplicant>opCust=repo.findById(customerId);
		if(opCust.isPresent())
		{
			LoanApplicant la=opCust.get();
			sl.setSanctionId(la.getCustomerId());
			sl.setSanctionDate(new Date());
			sl.setStatus("Credited");
			sl.setTermsCondition("The sanction is valid for 15 days.You can Accept or Reject the sanction.If no repiy received then,it will considered as rejected by applicant");
			la.setSaction(sl);
			LoanApplicant applicant=repo.save(la);
			return applicant;
			
		}
		else
		{
			throw new LoanApplicationNotFoundException("Please enter valid customer id.Given id is not present");
		}
		
	}

}
