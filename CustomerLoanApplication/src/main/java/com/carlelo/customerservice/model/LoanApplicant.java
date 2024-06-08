package com.carlelo.customerservice.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@Entity
public class LoanApplicant
{
    @Id
    private int customerId;
    private String customerName;
    private String customerDOB;
    private int customerAge;
    private String customerGender;
    private String customerEmail;
    private long cmobno;
    private long caddmobno;
    private double downPayment;
    private double totalLoan;
    private String loanStatus;  
    
    
    
  
    
    @OneToOne(cascade=CascadeType.ALL)
    private AllPersonalDocs documents;
    
    @OneToOne(cascade=CascadeType.ALL)
    private DependentInfo info;
    
    @OneToOne(cascade=CascadeType.ALL)
    private CustomerAddress address;
    
    @OneToOne(cascade=CascadeType.ALL)
    private MedicalDetails medical;
    
    @OneToOne(cascade=CascadeType.ALL)
    private CibilDetails cibil;
    
    @OneToOne(cascade=CascadeType.ALL)
    private AccountDetails account;
    
    @OneToOne(cascade=CascadeType.ALL)
    private GuarantorDetails guarantor;
    
    @OneToOne(cascade=CascadeType.ALL)
    private LoanDisbursement disbursment;
    
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Ledger> ledger;
    
    @OneToOne(cascade=CascadeType.ALL)
    private SanctionLetter saction;
    
   @OneToOne(cascade=CascadeType.ALL)
    private CustomerVerification verification;
}
