package com.carlelo.customerservice.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SanctionLetter 
{
   @Id
   private int sanctionId;
   private Date sanctionDate;
   private String applicantName;
   private long contactNo;
   private String onRoadPrice;
   private double loanAmtSanctioned;
   private String interestType;
   private float rateOfInterest;
   private int loanTenureInYear;
   private double monthlyEmiAmount;
   private String modeOfPayment;
   private String remarks;
   private String termsCondition;
   private String status;
   
}

