package com.carlelo.customerservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlelo.customerservice.model.SanctionLetter;
import com.carlelo.customerservice.repository.SanctionletterRepository;
import com.carlelo.customerservice.servicei.SanctionletteServiceI;

@Service
public class SanctionletterServiceImpL implements SanctionletteServiceI{

	@Autowired
	SanctionletterRepository slr;
	
	@Override
	public SanctionLetter updateSanction(SanctionLetter sl, int sanctionletteId) {
		
		if(slr.existsById(sanctionletteId)) {
			
			SanctionLetter vb=slr.save(sl);
			return vb;
		}
		
		return slr.save(sl) ;
	}

}
