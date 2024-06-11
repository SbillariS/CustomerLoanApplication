package com.carlelo.customerservice.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerVerification
{
	@Id
   private int verificationID;
   private Date verificationDate;
   private String status;
   private String remarks;
} 
