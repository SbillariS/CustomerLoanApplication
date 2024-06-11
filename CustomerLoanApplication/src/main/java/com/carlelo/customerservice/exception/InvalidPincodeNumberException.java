package com.carlelo.customerservice.exception;

public class InvalidPincodeNumberException extends RuntimeException {

	public InvalidPincodeNumberException(String message) 
	{
        super(message);
    }
}
