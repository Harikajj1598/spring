package org.jsp.merchantapp.execption;

import org.jsp.merchantapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MerchantAppExceptionHandler extends ResponseEntityExceptionHandler {	
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>handleINFE(IdNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(e.getMessage());
		structure.setData("Merchant is not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvaildCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>>handleICE(InvaildCredentialsException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(e.getMessage());
		structure.setData("Merchant is not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
