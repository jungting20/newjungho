package com.acorn.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.acorn.common.ErrorMessage;

@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorAdvice {
	
	@ExceptionHandler
	public ErrorMessage geterror(Exception ex){
		
		ErrorMessage err = new ErrorMessage();
		err.setErrstatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		err.setEmessage(ex.getMessage());
		return err;
	}
	
	
}
