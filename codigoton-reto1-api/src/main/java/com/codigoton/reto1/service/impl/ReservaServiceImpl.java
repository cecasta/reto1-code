package com.codigoton.reto1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigoton.reto1.db.repository.ClientFilterRepository;
import com.codigoton.reto1.db.specification.GenericSpesification;
import com.codigoton.reto1.db.specification.SearchCriteria;
import com.codigoton.reto1.db.specification.SearchOperation;
import com.codigoton.reto1.db.entities.Client;
import com.codigoton.reto1.dto.BalanceCuentasClient;
import com.codigoton.reto1.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ClientFilterRepository clientFilterRepository;	
	
	@Override
	public List<BalanceCuentasClient> generarReserva() {
	    String TIPO = "address";
	   String TIPO_VALUE = "BANDUNG";
	    String LOCATION = "age";
	    int LOCATION_VALUE = 25;
		
        GenericSpesification filterSpec = new GenericSpesification<Client>();
        filterSpec.add(new SearchCriteria(TIPO, TIPO_VALUE, SearchOperation.EQUAL));
        filterSpec.add(new SearchCriteria(LOCATION, LOCATION_VALUE, SearchOperation.GREATER_THAN));
        
        return clientFilterRepository.findAll(filterSpec);
	}

	@Override
	public List<BalanceCuentasClient> subirArchivoReserva() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
