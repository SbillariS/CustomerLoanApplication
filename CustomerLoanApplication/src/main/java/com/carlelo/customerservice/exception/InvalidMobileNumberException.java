package com.carlelo.customerservice.exception;

public class InvalidMobileNumberException extends RuntimeException {
	
    public InvalidMobileNumberException(String message) 
    {
        super(message);
    }
}
