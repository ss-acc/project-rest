package com.rest.card.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {
	
	@Id
	@Column(name = "cardno")
	private long cardno;
	
	@Column(name = "cardholdername")
	private String cardholdername;
	
	@Column(name = "cardbalance")
	private double cardbalance;
	
	@Column(name = "cardissueddate")
	private String cardissueddate;
	
	@Column(name = "cardexpirydate")
	private String cardexpirydate;
	
	
	@Column(name = "cardstatus")
	private String cardstatus;
	
	@Column(name = "bankid")
	public long bankid;
	
	
	public Card() {
		
	}

	
	public Card(long cardno, String cardholdername, double cardbalance, String cardissueddate, String cardexpirydate,
			String cardstatus, long bankid) {
		super();
		this.cardno = cardno;
		this.cardholdername = cardholdername;
		this.cardbalance = cardbalance;
		this.cardissueddate = cardissueddate;
		this.cardexpirydate = cardexpirydate;
		this.cardstatus = cardstatus;
		this.bankid = bankid;
	}


	public long getCardno() {
		return cardno;
	}


	public void setCardno(long cardno) {
		this.cardno = cardno;
	}


	public String getCardholdername() {
		return cardholdername;
	}


	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}


	public double getCardbalance() {
		return cardbalance;
	}


	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}


	public String getCardissueddate() {
		return cardissueddate;
	}


	public void setCardissueddate(String cardissueddate) {
		this.cardissueddate = cardissueddate;
	}


	public String getCardexpirydate() {
		return cardexpirydate;
	}


	public void setCardexpirydate(String cardexpirydate) {
		this.cardexpirydate = cardexpirydate;
	}


	public String getCardstatus() {
		return cardstatus;
	}


	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}


	public long getBankid() {
		return bankid;
	}


	public void setBankid(long bankid) {
		this.bankid = bankid;
	}

	
	
	

}
