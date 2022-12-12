package com.Bank.BankMG.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Bank.BankMG.entity.Account;
import com.Bank.BankMG.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController
{
	@Autowired
	private AccountService accountservice;
	

	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account)
	{
		return new ResponseEntity<Account> (accountservice.createAccount(account) , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/viewAccount/{id}")
	public ResponseEntity<Account> viewAccount(@Valid @RequestBody Account account, @PathVariable int id)
	{
		return new ResponseEntity<Account> (accountservice.viewAccount(id) , HttpStatus.OK);
		
	}
	
	@PutMapping("/updateAccount/{id}")
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account, @PathVariable int id)
	{
		return new ResponseEntity<Account> (accountservice.updateAccount(account,id) , HttpStatus.OK);
		
	};
	@DeleteMapping("/deleteAccount/{id}")
	public  String deleteAccount(@Valid @RequestBody Account account ,@PathVariable int id)
	{
		 return accountservice.deleteAccount(account, id) ;
		
	}
	
	@PutMapping("/account/{id}/withdraw/{amount}")
	public String  withdraw( @PathVariable int id,@PathVariable double amount)
	{
		return accountservice.withdraw( id,amount);
		
		
	}
	
	@PutMapping("/deposit/{id}")
	public String deposit(@RequestBody Account account, @PathVariable int id) 
	{
		return accountservice.deposit(account, id);
		
	}
	
	@GetMapping("/account/{id}")
	public double getbalance(@RequestBody Account account ,@PathVariable int id)
	{
		return accountservice.getbalance(account, id);
	}
	
	
}
