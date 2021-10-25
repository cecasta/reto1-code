package com.codigoton.reto1.dto;

import java.math.BigDecimal;

public class BalanceCuentasClient {

	private long clientId;
	private String code;
	private int male;
	private int type;
	private String location;
	private String company;
	private int encrypt;
	private BigDecimal sumBalance;
	
	public BalanceCuentasClient(long clientId, String code, int male, int type, String location, String company, int encrypt,
			BigDecimal sumBalance) {
		this.clientId = clientId;
		this.code = code;
		this.male = male;
		this.type = type;
		this.location = location;
		this.company = company;
		this.encrypt = encrypt;
		this.sumBalance = sumBalance;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
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
	public BigDecimal getSumBalance() {
		return sumBalance;
	}
	public void setSumBalance(BigDecimal sumBalance) {
		this.sumBalance = sumBalance;
	}
}
