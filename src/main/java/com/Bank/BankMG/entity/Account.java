package com.Bank.BankMG.entity;





import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name="CurrentBalance")
	private double currentBalance;
	
	@Column(name="BankName")
	private String bankName;

	/*@Min(value = 3)
	@Max(value = 15)8*/
	@Column(name="OwnerFName")
	private String ownerFName;

	/*@Min(value = 3)
	@Max(value = 15)*/
	@Column(name="ownerLName")
	private String ownerLName;
	
	
	@Column(name="phoneNo")
	private long phoneNo;

	
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "account")
	@JsonManagedReference
	private Bank bank;
    
	
	

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public double getCurrentBalance() {
		return currentBalance;
	}

	public double setCurrentBalance(double currentBalance) {
		return this.currentBalance = currentBalance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getOwnerFName() {
		return ownerFName;
	}

	public void setOwnerFName(String ownerFName) {
		this.ownerFName = ownerFName;
	}

	public String getOwnerLName() {
		return ownerLName;
	}

	public void setOwnerLName(String ownerLName) {
		this.ownerLName = ownerLName;
	}
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	protected Account() {

	}

	public Account(int id,  double currentBalance, String bankName, String ownerFName,String ownerLName,Bank bank) {
		super();
		this.id = id;
		
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.ownerFName = ownerFName;
		this.ownerLName = ownerLName;
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", currentBalance=" + currentBalance
				+ ", bankName=" + bankName + ", ownerFName=" + ownerFName + ", ownerLName=" + ownerLName + ", bank="
				+ bank + "]";
	}

	

}
