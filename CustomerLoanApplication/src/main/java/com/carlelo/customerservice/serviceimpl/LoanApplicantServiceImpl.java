package com.carlelo.customerservice.serviceimpl;
import java.util.List;
import java.util.Optional;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.multipart.MultipartFile;
import com.carlelo.customerservice.model.AllPersonalDocs;
import com.carlelo.customerservice.model.CibilDetails;
import com.carlelo.customerservice.model.CustomerVerification;
import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.repository.CustomerVerificationRepository;
import com.carlelo.customerservice.repository.LoanApplicantRepository;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class LoanApplicantServiceImpl implements LoanApplicantServiceI
{
	@Autowired LoanApplicantRepository repo;
	@Autowired CustomerVerificationRepository verificationrepo;

	@Override
	public LoanApplicant addCustomerDetails(String customerdetails,MultipartFile profaddr,
			MultipartFile profpan, MultipartFile profphoto, MultipartFile profit,
			MultipartFile profadhar,MultipartFile profsign, MultipartFile profchecque, 
			MultipartFile profsslip,String enquiryId,CibilDetails cd) 
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
		if(app!=null)
		{
			try {
				AllPersonalDocs app2=new AllPersonalDocs();
				app2.setAddressProof(profaddr.getBytes());
				app2.setAddharCard(profadhar.getBytes());
				app2.setBankcheque(profchecque.getBytes());
				app2.setIncomeTax(profit.getBytes());
				app2.setPanCard(profpan.getBytes());
				app2.setPhoto(profphoto.getBytes());
				app2.setSalarySlips(profsslip.getBytes());
				app2.setSignature(profsign.getBytes());
				app.setDocuments(app2);
				app.setCibil(cd);
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		return repo.save(app);
	}


	
	  //update
	@Override
	public LoanApplicant updateLoanApplicant(String customerdetails, MultipartFile profaddr, MultipartFile profpan,
			MultipartFile profphoto, MultipartFile profit, MultipartFile profadhar, MultipartFile profsign,
			MultipartFile profchecque, MultipartFile profsslip) {
		
		
		ObjectMapper mapper=new ObjectMapper();
		LoanApplicant up=null;
		
		
		try {
			up=mapper.readValue(customerdetails, LoanApplicant.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if(up!=null)
		{
			try {
				AllPersonalDocs app2=new AllPersonalDocs();
				app2.setAddressProof(profaddr.getBytes());
				app2.setAddharCard(profadhar.getBytes());
				app2.setBankcheque(profchecque.getBytes());
				app2.setIncomeTax(profit.getBytes());
				app2.setPanCard(profpan.getBytes());
				app2.setPhoto(profphoto.getBytes());
				app2.setSalarySlips(profsslip.getBytes());
				app2.setSignature(profsign.getBytes());
				up.setDocuments(app2);
				/*app.setInfo(app1);
				app.setAccount(app3);
				app.setCibil(app4);
				app.setAddress(app5);
				app.setVerification(app6);
				app.setGuarantor(app7);
				app.setLedger(null);
				app.setDisbursment(app9);
				app.setMedical(app10);
				app.setSaction(app11);*/
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		return repo.save(up);

	}

	

	
	
	@Override

	public LoanApplicant patchData(String loanjason, MultipartFile documentid, MultipartFile addressproof,
			MultipartFile pancard, MultipartFile incomeTax, MultipartFile adcardd, MultipartFile img,
			MultipartFile signature, MultipartFile banqcheque, MultipartFile salaryslip) {
		ObjectMapper mapper=new ObjectMapper();
		LoanApplicant app=null;
	
		
		try {
			app=mapper.readValue(loanjason, LoanApplicant.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if(app!=null)
		{
			try {
				AllPersonalDocs app2=new AllPersonalDocs();
				app2.setAddressProof(documentid.getBytes());
				app2.setAddharCard(addressproof.getBytes());
				app2.setBankcheque(pancard.getBytes());
				app2.setIncomeTax(incomeTax.getBytes());
				app2.setPanCard(adcardd.getBytes());
				app2.setPhoto(img.getBytes());
				app2.setSalarySlips(signature.getBytes());
				app2.setSignature(banqcheque.getBytes());
				app2.setSignature(salaryslip.getBytes());
				app.setDocuments(app2);
			
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		return repo.save(app);
	}
	

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

	@Override
	public CustomerVerification updateCustomerVerification(int verificationID,CustomerVerification cv) 
	{
		if(verificationrepo.existsById(verificationID))
		{
			return verificationrepo.save(cv);
		}
		return cv;
	}
}