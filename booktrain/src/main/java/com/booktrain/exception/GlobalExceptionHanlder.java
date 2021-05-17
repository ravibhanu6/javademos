package com.booktrain.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ControllerAdvice
public class GlobalExceptionHanlder {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		
		System.out.println("Handle Exceptions");
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	if(error instanceof  FieldError) {
	    		String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);	
	    	}else {
	    		String fieldName = ((ObjectError) error).getCode();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
	    	}
	    });
	    System.out.println(errors);
	    return errors;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String,String> handleExcpetion(Exception e){
		
		System.out.println("Got Exception");
		e.printStackTrace();
		Map<String,String> errors=new HashMap<>();
		errors.put("message","Something Went Wrong");
		return errors;
		
	}
	
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ExceptionHandler(NotEnoughSeatsException.class)
	@ResponseBody
	public Map<String,String> handleNotEnoughSeatsException(NotEnoughSeatsException e){
		
		System.out.println("Got Exception");
		e.printStackTrace();
		Map<String,String> errors=new HashMap<>();
		errors.put("message",e.getMessage()+" on "+e.getDate());
		errors.put("trainId",e.getTrainId()+"");
		return errors;
		
	}

}
