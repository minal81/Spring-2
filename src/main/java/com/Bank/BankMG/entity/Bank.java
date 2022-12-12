package com.Bank.BankMG.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bank")
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Bankid;
	
	//@NotBlank(message="IFSCcode is complusory")
	@Column(name="IFSCcode")
	private String IFSCcode;
	
	//@NotBlank(message="Branch is complusory")
	@Column(name="Branch")
	private String Branch;
	
	
	@Column(name="state")
	private String State;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Accountid")
	@JsonBackReference
	private Account account;

public int getBankid() {
	return Bankid;
}

public void setBankid(int bankid) {
	Bankid = bankid;
}

public String getIFSCcode() {
	return IFSCcode;
}

public void setIFSCcode(String iFSCcode) {
	IFSCcode = iFSCcode;
}

public String getBranch() {
	return Branch;
}

public void setBranch(String branch) {
	Branch = branch;
}

public String getState() {
	return State;
}

public void setState(String state) {
	State = state;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}

	

}