package com.codigoton.reto1.db.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	private long id;
	
	@Column(name = "code")
	private String code;

	@Column(name = "male")
	private int male;

	@Column(name = "type")
	private int type;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "encrypt")
	private int encrypt;

	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private List<Account> accounts;

	public Client(long id, String code, int male, int type, String location, String company, int encrypt,
			List<Account> accounts) {
		super();
		this.id = id;
		this.code = code;
		this.male = male;
		this.type = type;
		this.location = location;
		this.company = company;
		this.encrypt = encrypt;
		this.accounts = accounts;
	}
	
	public Client() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(int encrypt) {
		this.encrypt = encrypt;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
