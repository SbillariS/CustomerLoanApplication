package com.carlelo.customerservice.exception;

public class InvalidPincodeException extends RuntimeException {

	public InvalidPincodeException(String message) {
        super(message);
    }
}
