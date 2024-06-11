package com.carlelo.customerservice.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.carlelo.customerservice.dto.ResponseDto;
import com.carlelo.customerservice.exception.LoanApplicationNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionsHandler 
{
    @ExceptionHandler(LoanApplicationNotFoundException.class)
    public ResponseEntity<ResponseDto> handleLoanApplicationNotFound(LoanApplicationNotFoundException ue)
    {
    	ResponseDto response=new ResponseDto(ue.getMessage(), new Date());
		return new ResponseEntity<ResponseDto>(response,HttpStatus.NOT_FOUND);
    }
}
