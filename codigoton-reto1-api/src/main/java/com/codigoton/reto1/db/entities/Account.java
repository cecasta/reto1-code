package com.codigoton.reto1.db.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	private long id;
	
	@Column(name = "client_id")
	private long client_id;

	@Column(name = "balance")
	private BigDecimal balance;
	
	
	public Account(long id, long client_id, BigDecimal balance) {
		this.id = id;
		this.client_id = client_id;
		this.balance = balance;
	}
	public Account() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClient_id() {
		return client_id;
	}

	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



}
