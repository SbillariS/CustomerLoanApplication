package com.carlelo.customerservice.servicei;

import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.model.SanctionLetter;

public interface SanctionletteServiceI 
{

public LoanApplicant updateSanction(SanctionLetter sl, int customerId);

}
