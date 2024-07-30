package com.carlelo.customerservice.serviceimpl;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.carlelo.customerservice.exception.LoanApplicationNotFoundException;
import com.carlelo.customerservice.exception.InvalidEmailException;
import com.carlelo.customerservice.exception.InvalidMobileNumberException;
import com.carlelo.customerservice.exception.InvalidPincodeNumberException;
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
			MultipartFile profsslip) 
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
		 if (app != null) 
		 {
		
			try {
				AllPersonalDocs app2=new AllPersonalDocs();
				app2.setAddressProof(profaddr.getBytes());
if(profadhar!=null)			app2.setAddharCard(profadhar.getBytes());
if(profchecque!=null)				app2.setBankcheque(profchecque.getBytes());
if(profit!=null)				app2.setIncomeTax(profit.getBytes());
				app2.setPanCard(profpan.getBytes());
				app2.setPhoto(profphoto.getBytes());
if(profsslip!=null)			app2.setSalarySlips(profsslip.getBytes());
if(profsign!=null)				app2.setSignature(profsign.getBytes());
				app.setDocuments(app2);
				
			}
		 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		 
		}
			 if(app.getCmobno().length()==10)
			 {
				 if(app.getCustomerEmail().endsWith("@gmail.com")) 
				 {
					 if(app.getAddress().getPinCode().length()==6)
					 {
				          return repo.save(app);
				     }
					 else
					 {
						 throw new InvalidPincodeNumberException("You have entered invalid pincode.Please enter valid 6 digit pincode number");
					 }
				 }
				 else
				 {
					 throw new InvalidEmailException("You have entered invalid email.Please correct it.");
				 }
			  }
		    else
		    {
	         throw new InvalidMobileNumberException("Please enter 10 digit valid mobile number"); 
					 
	        }
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
		else {
			 throw new LoanApplicationNotFoundException("Customer Id is invalid ,so please enter correct Customer Id");
		}
	}

	@Override
	public List<LoanApplicant> deleteSingleApplicant(int customerId)
	{
		if(repo.existsById(customerId))
		{
		   repo.deleteById(customerId);
		   return repo.findAll();
		}
		else {
			 throw new LoanApplicationNotFoundException("Customer Id is invalid ,so please enter correct Customer Id");
		}
	}

	@Override
	public void deleteAllApplicant() 
	{
		 repo.deleteAll();
	}



	@Override
	public CustomerVerification VerifyLoanApplication(int customerId, CustomerVerification cv)
	{
		Optional<LoanApplicant> opCust=repo.findById(customerId);
		if(opCust.isPresent())
		{
			LoanApplicant customer=opCust.get();
			cv.setVerificationID(customer.getCustomerId());
			cv.setVerificationDate(new Date());
			customer.setVerification(cv);
			repo.save(customer);
		}
		else
		{
		 throw new LoanApplicationNotFoundException("Customer Id is invalid ,so please enter correct Customer Id");
		}
		return cv;
	}

	}


