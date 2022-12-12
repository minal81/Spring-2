package com.Bank.BankMG.exception;

import org.springframework.http.HttpStatus;



public class ErrorMessage {
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	private String message;
	private HttpStatus status;

}
