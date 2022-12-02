package com.fashion.gtest.exception;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServerSideValidator extends ResponseEntityExceptionHandler  {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		System.out.println("\n\n =====>>  Inside ServerSideInsuranceValidator ");
		Map<String, String> errorMap = new HashMap<>();
		
		
		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

		errorList.stream().forEach((e)->{
			String propertyName = ((FieldError)e).getField();
			String errorMsg = e.getDefaultMessage();
			
			errorMap.put(propertyName, errorMsg);
		});
		
		
		return new ResponseEntity<Object>(errorMap,HttpStatus.BAD_REQUEST);
		
	}
	
	

	
	
		
		
}
