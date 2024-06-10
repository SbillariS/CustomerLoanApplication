package com.carlelo.customerservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.customerservice.model.LoanDisbursement;
import com.carlelo.customerservice.repository.loanDisbursementRepository;
import com.carlelo.customerservice.servicei.LoanDisbursementServiceI;
@Service
public class loanDisbursementServiceImpl implements LoanDisbursementServiceI 
{
    @Autowired
      loanDisbursementRepository ldr;

	@Override
	public LoanDisbursement saveData(LoanDisbursement ld, int agreeID) {
	if(ldr.existsById(agreeID))
	{
		LoanDisbursement ld1=ldr.save(ld);
		return ld1;
	}
	else
	{
		return ldr.save(ld);
	}
	
	}

	
    

}
