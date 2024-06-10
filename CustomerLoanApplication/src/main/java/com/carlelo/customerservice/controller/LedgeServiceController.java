package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.customerservice.model.Ledger;
import com.carlelo.customerservice.servicei.LedgerServiceI;

@RestController
public class LedgeServiceController 
{
	@Autowired LedgerServiceI lsi;
	
	
	@PutMapping("/addLedgerData/{lid}")
	public ResponseEntity<Ledger> addLedgerData(@RequestBody Ledger l,@PathVariable int lid)
	{
		Ledger led=lsi.addLedger(l,lid);
		return new ResponseEntity<Ledger>(led,HttpStatus.ACCEPTED);
		
	}

}
