package com.codigoton.reto1.dto;

import java.math.BigDecimal;

public class FiltroSolicitudReserva {
	private String name;
	private int type;
	private String location;
	private BigDecimal ri;
	private BigDecimal rf;
	
	
	public FiltroSolicitudReserva(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public BigDecimal getRi() {
		return ri;
	}
	public void setRi(BigDecimal ri) {
		this.ri = ri;
	}
	public BigDecimal getRf() {
		return rf;
	}
	public void setRf(BigDecimal rf) {
		this.rf = rf;
	}
	
	
	
	
}
