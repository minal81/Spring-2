package com.Bank.BankMG.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.BankMG.entity.User;
import com.Bank.BankMG.repository.UserRepository;
import com.Bank.BankMG.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository urepo;
	
	@Override
	public User loginU(String userName, String password) {
		User user = urepo.findByUserNameAndPassword(userName, password);
		return user;
	}

}
