package com.rest.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	@Column(name = "bankid")
	private long bankid;
	
	@Column(name = "bankname")
	private String bankname;
	

	@Column(name = "bankaddress")
	private String bankaddress;
	

	@Column(name = "cardcount")
	private short cardcount;
	

	public Bank() {
		
	}


	public Bank(long bankid, String bankname, String bankaddress,short cardcount) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.bankaddress = bankaddress;
		this.cardcount = cardcount;
	}


	public long getBankid() {
		return bankid;
	}


	public void setBankid(long bankid) {
		this.bankid = bankid;
	}


	public String getBankname() {
		return bankname;
	}


	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


	public String getBankaddress() {
		return bankaddress;
	}


	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}


	public short getCardcount() {
		return cardcount;
	}


	public void setCardcount(short cardcount) {
		this.cardcount = cardcount;
	}

//	public getcardcount(long bankid) {
//		return cardcount;
//	}
	
	

}
