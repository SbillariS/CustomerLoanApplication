package com.carlelo.customerservice.exception;

public class LoanApplicationNotFoundException extends RuntimeException
{
   public LoanApplicationNotFoundException(String msg)
   {
	   super(msg);
   }
}
