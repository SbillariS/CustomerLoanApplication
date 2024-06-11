package com.carlelo.customerservice.handler;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carlelo.customerservice.dto.ResponseDto;
import com.carlelo.customerservice.exception.InvalidPincodeNumberException;

public class PincodeNumberExceptionHandler 
{
	@ExceptionHandler(InvalidPincodeNumberException.class)
	public ResponseEntity<ResponseDto> handlePincodeNumberException(InvalidPincodeNumberException pe)
	{
		ResponseDto rd=new ResponseDto(pe.getMessage(),new Date());
		return new ResponseEntity<ResponseDto> (rd,HttpStatus.BAD_REQUEST);
		
	}

}
