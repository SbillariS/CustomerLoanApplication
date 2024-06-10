package com.carlelo.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlelo.customerservice.model.SanctionLetter;
import com.carlelo.customerservice.servicei.SanctionletteServiceI;

@RestController
public class SanctionletterController {
	
	@Autowired
	SanctionletteServiceI ss;
	
	@PutMapping("updateSanctionlette/{SanctionletteId}")
	public ResponseEntity<SanctionLetter> updateSanction(@RequestBody SanctionLetter sl,@PathVariable int SanctionletteId )
	{
		SanctionLetter xz=ss.updateSanction(sl,SanctionletteId);
				return new ResponseEntity<SanctionLetter>(xz, HttpStatus.ACCEPTED);
	}

}
