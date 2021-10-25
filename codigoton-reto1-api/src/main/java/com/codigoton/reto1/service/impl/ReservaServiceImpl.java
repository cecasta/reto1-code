package com.codigoton.reto1.service.impl;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigoton.reto1.db.repository.ClientFilterRepository;
import com.codigoton.reto1.db.repository.ClientRepository;
import com.codigoton.reto1.db.specification.GenericSpesification;
import com.codigoton.reto1.db.specification.SearchCriteria;
import com.codigoton.reto1.db.specification.SearchOperation;
import com.codigoton.reto1.db.entities.Client;
import com.codigoton.reto1.dto.BalanceCuentasClient;
import com.codigoton.reto1.dto.FiltroSolicitudReserva;
import com.codigoton.reto1.dto.ReservaMesaRs;
import com.codigoton.reto1.reserva.ProcesarSolicitud;
import com.codigoton.reto1.reserva.SolicitudReserva;
import com.codigoton.reto1.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ClientRepository clientRepository;	
   
    private SolicitudReserva solicitud = new SolicitudReserva();
    private ProcesarSolicitud procesar = new ProcesarSolicitud();
	@Override
	public List<ReservaMesaRs> generarReserva(Path rutaSolicitudReserva) {
		List<FiltroSolicitudReserva> filtros = solicitud.obtenerFiltroReserva(rutaSolicitudReserva);
		List<ReservaMesaRs> rs = new ArrayList<ReservaMesaRs>();
		filtros.forEach(filtro -> {
			List<BalanceCuentasClient> result = clientRepository.getBalanceClients(filtro.getType(), filtro.getLocation(), 
					filtro.getRi(), filtro.getRf());
			if(result != null)
				rs.add(procesar.procesarSolicitud(result, filtro));
		});
		return  rs;
	}


}
