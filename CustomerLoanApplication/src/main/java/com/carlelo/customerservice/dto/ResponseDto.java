package com.carlelo.customerservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto 
{
	 private String message;
	 private Date timeStamp;
	public ResponseDto(String message, Date timeStamp) 
	{
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	 
}
