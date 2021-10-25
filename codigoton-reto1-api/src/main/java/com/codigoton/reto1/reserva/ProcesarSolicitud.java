package com.codigoton.reto1.reserva;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import com.codigoton.reto1.dto.BalanceCuentasClient;
import com.codigoton.reto1.dto.FiltroSolicitudReserva;
import com.codigoton.reto1.dto.ReservaMesaRs;

public class ProcesarSolicitud {

	private List<String> clientes = new ArrayList();
	private List<String> listEmpresas = new ArrayList<>();
	private int totalHombres = 0;
	private int totalMujeres = 0;
	public ReservaMesaRs procesarSolicitud(List<BalanceCuentasClient> balances, FiltroSolicitudReserva filtro) {
		ReservaMesaRs rs = new ReservaMesaRs();
		
		balances.forEach(balance -> {
			if(validarCliente(balance)) {
				clientes.add(balance.getCode());
				listEmpresas.add(balance.getCompany());
				if(balance.getMale() == 1) {
					totalHombres += 1;
				}else {
					totalMujeres += 1;
				}
			}
			if(clientes.size() == 8)
				return;
		});
		
		rs.setName(filtro.getName());
		rs.setClients(clientes);
		return rs;
	}
	
	private boolean validarCliente(BalanceCuentasClient balance) {
		if(clientes.isEmpty())
			return true;
		for (String s : listEmpresas) {
            if (s.contains(balance.getCompany())) {
                return false;
            }
		}
		if(balance.getMale() == 1) {
			if(totalHombres >= 4) {
				return false;
			}
		}
		if(balance.getMale() == 0) {
			if(totalMujeres >= 4) {
				return false;
			}
		}
			
		return true;
	}
}
