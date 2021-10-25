package com.codigoton.reto1.dto;

import java.util.List;

public class ReservaMesaRs {
	private String name;
	private List<String> clients;
	private String estado;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getClients() {
		return clients;
	}
	public void setClients(List<String> clients) {
		this.clients = clients;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	

	

}
