package com.carlelo.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class LoanDisbursement {
    @Id
  private int agreementId;
    private int loanNo;
    private String agreementDate;
    private String amountPayType;
    private double   totalAmount;
    private String bankName;
    private long  accountNumber;
    private String ifsc_code;
    private String accountType;
    private double  transferAmount;
    private String  paymentStatus;
    private String  amountPaidDate;
      
}
