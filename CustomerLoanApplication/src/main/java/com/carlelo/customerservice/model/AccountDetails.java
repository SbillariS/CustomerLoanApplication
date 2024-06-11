package com.carlelo.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AccountDetails 
{
	@Id
	private int accountId;
	private String accountType;
	private Double accountBalance;
	private  String accountHolderName;
	private String accountStatus;
	private long accountNumber;

}
