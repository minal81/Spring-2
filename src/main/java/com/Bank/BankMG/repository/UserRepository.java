package com.Bank.BankMG.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.BankMG.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserNameAndPassword(String userName, String password);

}