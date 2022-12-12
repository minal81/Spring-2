package com.Bank.BankMG.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.BankMG.entity.User;
import com.Bank.BankMG.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String validate(@RequestBody User user) throws ServletException{
		String jwtToken = "";
		
		if(user.getUserName() == null || user.getPassword() == null) {
			throw new ServletException("Please fill username & password");
		}
		
		String userName = user.getUserName();
		String password = user.getPassword();
		user = userService.loginU(userName, password);
		
		if(user == null) {
			throw new ServletException("User not found ");
		}
		
		jwtToken = Jwts.builder().setSubject(userName).claim("roles", "user")
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		return jwtToken;
	}

}