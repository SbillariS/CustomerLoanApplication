package com.carlelo.customerservice.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.carlelo.customerservice.model.Ledger;
import com.carlelo.customerservice.repository.LedgerRepositoryI;
import com.carlelo.customerservice.servicei.LedgerServiceI;

@Service
public class LedgerServiceImpl implements LedgerServiceI
{
	@Autowired
	LedgerRepositoryI lri;

	@Override
	public Ledger addLedger(Ledger l, int lid) 
	{
		
		if(lri.existsById(lid))
		{
			Ledger ledger=lri.save(l);
			return ledger;
		}
		return lri.save(l);
	     
	}
	
	

}
