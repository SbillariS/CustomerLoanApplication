package com.carlelo.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SanctionLetter 
{
   @Id
   private int sanctionId;
   private String sanctionDate;
   private String applicantName;
   private long ContactNo;
   private String producthomeEquity;
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
