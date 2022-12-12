package com.Bank.BankMG.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {
	@ExceptionHandler(Accountexception.class)
	public ResponseEntity<ErrorMessage> handlerStudentException(Accountexception ex ,WebRequest request){
		ErrorMessage errorMessage= new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}

}
