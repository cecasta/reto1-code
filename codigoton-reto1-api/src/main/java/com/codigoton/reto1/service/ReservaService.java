package com.codigoton.reto1.service;

import java.util.List;

import com.codigoton.reto1.dto.BalanceCuentasClient;

public interface ReservaService {
	List<BalanceCuentasClient> generarReserva();
	List<BalanceCuentasClient> subirArchivoReserva();
	

}
