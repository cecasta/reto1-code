package com.codigoton.reto1.service;

import java.nio.file.Path;
import java.util.List;

import com.codigoton.reto1.dto.ReservaMesaRs;

public interface ReservaService {
	List<ReservaMesaRs> generarReserva(Path rutaSolicitudReserva);
	

}
