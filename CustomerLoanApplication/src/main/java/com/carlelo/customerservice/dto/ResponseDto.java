package com.carlelo.customerservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto 
{
	 private String message;
	 private Date timeStamp;	
	 
}
