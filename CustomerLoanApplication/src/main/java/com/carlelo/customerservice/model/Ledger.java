package com.carlelo.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ledger 
{
  @Id
 private int ledgerId;
  private String ledgerCreatedDate;
  private double totalLoanAmount;
  private double payableAmountwithInterest;
  private int tenure;
  private double monthlyEMI;
  private double amountPaidtillDate;
  private double remainingAmount;
  private String nextEmiDatestart;
  private String nextEmiDateEnd;
  private int defaulterCount;
  private String previousEmitStatus;
  private String currentMonthEmiStatus;
  private String loanEndDate;
  private String loanStatus;

}
