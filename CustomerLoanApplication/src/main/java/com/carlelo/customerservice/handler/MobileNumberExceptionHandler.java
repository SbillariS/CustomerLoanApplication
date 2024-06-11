package com.carlelo.customerservice.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carlelo.customerservice.dto.ResponseDto;
import com.carlelo.customerservice.exception.InvalidMobileNumberException;

public class MobileNumberExceptionHandler 
{
	@ExceptionHandler(InvalidMobileNumberException.class)
	public ResponseEntity<ResponseDto> handleMobileNumberException(InvalidMobileNumberException me)
	{
		ResponseDto rd=new ResponseDto(me.getMessage(),new Date());
		return new ResponseEntity<ResponseDto> (rd,HttpStatus.CONFLICT);
		
	}

}
