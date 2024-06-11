package com.carlelo.customerservice.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carlelo.customerservice.exception.InvalidEmailException;
import com.carlelo.customerservice.exception.InvalidMobileNumberException;
import com.carlelo.customerservice.exception.InvalidPincodeException;
import com.carlelo.customerservice.model.AllPersonalDocs;
import com.carlelo.customerservice.model.LoanApplicant;
import com.carlelo.customerservice.repository.LoanApplicantRepository;
import com.carlelo.customerservice.servicei.LoanApplicantServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoanApplicantServiceImpl implements LoanApplicantServiceI {

    @Autowired
    LoanApplicantRepository repo;

    @Override
    public LoanApplicant addCustomerDetails(String customerdetails, MultipartFile profaddr, MultipartFile profpan,
            MultipartFile profphoto, MultipartFile profit, MultipartFile profadhar, MultipartFile profsign,
            MultipartFile profchecque, MultipartFile profsslip) {
        
        ObjectMapper mapper = new ObjectMapper();
        LoanApplicant app = null;

        try {
            app = mapper.readValue(customerdetails, LoanApplicant.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (app != null) {
            validateMobileNumber(app.getCmobno());
            validateEmail(app.getCustomerEmail());

            try {
                AllPersonalDocs app2 = new AllPersonalDocs();
                app2.setAddressProof(profaddr.getBytes());
                app2.setAddharCard(profadhar.getBytes());
                app2.setBankcheque(profchecque.getBytes());
                app2.setIncomeTax(profit.getBytes());
                app2.setPanCard(profpan.getBytes());
                app2.setPhoto(profphoto.getBytes());
                app2.setSalarySlips(profsslip.getBytes());
                app2.setSignature(profsign.getBytes());
                app.setDocuments(app2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return repo.save(app);
        }
        return null;
    }

    private void validateMobileNumber(long mobileNumber) {
        String mobileNumberStr = String.valueOf(mobileNumber);
        if (mobileNumberStr.length() != 10 || !mobileNumberStr.matches("\\d{10}")) {
            throw new InvalidMobileNumberException("Invalid mobile number: " + mobileNumber);
        }
    }

	/*
	 * private void validatePincode(int pincode) { String pincodeStr =
	 * String.valueOf(pincode); if (pincodeStr.length() != 6 ||
	 * !pincodeStr.matches("\\d{6}")) { throw new
	 * InvalidPincodeException("Invalid pincode: " + pincode); } }
	 */

    private void validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailException("Invalid email address: " + email);
        }
    }

    @Override
    public List<LoanApplicant> GetAllApplicantDetails() {
        return repo.findAll();
    }

    @Override
    public LoanApplicant GetSingleApplicant(int customerId) {
        Optional<LoanApplicant> optional = repo.findById(customerId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<LoanApplicant> deleteSingleApplicant(int customerId) {
        if (repo.existsById(customerId)) {
            repo.deleteById(customerId);
            return repo.findAll();
        }

        return null;
    }

    @Override
    public void deleteAllApplicant() {
        repo.deleteAll();
    }
}
