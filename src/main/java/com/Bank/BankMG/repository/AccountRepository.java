package com.Bank.BankMG.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Bank.BankMG.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
	
	//custom Query for finding Account Details using  owner first name
	@Query("select currentBalance from Account where id=?1")
	public double findBalanceByAcctID(int acctID);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Account set currentBalance = currentBalance-?2 where id=?1")
	public void withdrawByAcctID(int id, double  currentBalance);
	 
    
}
