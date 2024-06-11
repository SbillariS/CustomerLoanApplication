package com.carlelo.customerservice.handler;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carlelo.customerservice.dto.ResponseDto;
import com.carlelo.customerservice.exception.InvalidEmailException;

public class EmailIdExceptionHandler 
{
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ResponseDto>handleemailinvalidException(InvalidEmailException ee)
	{
		ResponseDto rd=new ResponseDto(ee.getMessage(),new Date());
		return new ResponseEntity<ResponseDto>(rd,HttpStatus.BAD_REQUEST);
		
	}

}
