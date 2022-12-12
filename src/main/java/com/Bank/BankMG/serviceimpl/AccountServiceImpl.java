package com.Bank.BankMG.serviceimpl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Bank.BankMG.entity.Account;
import com.Bank.BankMG.exception.Accountexception;
import com.Bank.BankMG.repository.AccountRepository;
import com.Bank.BankMG.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService
{
	Account account;
	@Autowired
	AccountRepository accountrepository;
	

	@Override
	public Account createAccount(Account account) {

		return accountrepository.save(account);
	}

	@Override
	public Account viewAccount(int id) {

		return accountrepository.findById(id).orElseThrow(() -> new Accountexception("incorrect Account Details"));
	}

	@Override
	public Account updateAccount(Account account, int id) {
		Account a1 = accountrepository.findById(id).orElseThrow(() -> new Accountexception("incorrect Account Details"));
		a1.setPhoneNo(account.getPhoneNo());
		accountrepository.save(a1);
		return a1;
	}

	@Override
	public String deleteAccount(Account account,int id) {
		accountrepository.findById(id).orElseThrow(() -> new Accountexception("incorrect Account Details"));
		accountrepository.deleteById(id);
		return "Delete Successfully";
	}

	
	@Override
	public String deposit(Account account, int id) {
		Account a1 = accountrepository.findById(id).orElseThrow(() -> new Accountexception("incorrect Account Details"));
		double currentBal = account.getCurrentBalance();
		double amt = a1.setCurrentBalance(a1.getCurrentBalance());
		a1.setCurrentBalance(currentBal+amt);
		accountrepository.save(a1);
		return "Deposit Successfully";
		
	}

	@Override
	public double getbalance(Account account, int id) {
		
		return accountrepository.findBalanceByAcctID(id);
	}

	@Override
	public String withdraw(int id, double amount) {
		accountrepository.withdrawByAcctID(id, amount);
		return "Withdraw Successfully";
	}

	

	


	

}
