package com.Bank.BankMG.service;



import com.Bank.BankMG.entity.Account;



public interface AccountService {
	
	//to create a account
	Account createAccount(Account account);
	
	
	// to view account using account id
	Account viewAccount(int id);
	
	
	//to update data
	Account updateAccount(Account account,int id);
	
	//to delete the account
    public String deleteAccount(Account account,int id);
 
    // to withdraw the amount
    public String  withdraw(int id,double amount);
 	
 	
 	//to deposit the amount
     public String  deposit(Account account,int id);
 	
 	//to find the balance using account id
    public double getbalance(Account account,int id);
 	
    
}
