package com.codigoton.reto1.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codigoton.reto1.db.entities.Client;
import com.codigoton.reto1.db.entities.ClientGroup;
import com.codigoton.reto1.db.repository.ClientRepository;
import com.codigoton.reto1.dto.BalanceCuentasClient;

@RestController
@RequestMapping("/api")
public class Reserva {
	
	
	@Autowired
	private ClientRepository clientRepository;

//	@GetMapping("/reserva")
//	public ResponseEntity<List<ClientGroup>> getClients2() {
//		List<ClientGroup> clients = clientRepository.getBalanceClients();
//		return ResponseEntity.ok(clients);
//	}
	@GetMapping("/client")
	public ResponseEntity<List<Client>> getClients() {
		List<Client> clients = clientRepository.findAll();
		return ResponseEntity.ok(clients);
	}
	
	@GetMapping("/client/balance")
	public ResponseEntity<List<BalanceCuentasClient>> getBalanceClients() {
		String filter = "TC;1,UG:3,RI:1000,RF:2000";
		int type;
		String location = null;
		BigDecimal ri = null, rf = null;
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(filter + ",");
        while (matcher.find()) {
            switch (matcher.group(1)) {
            case "TC":
            	//type = matcher.group(3);
            	break;
            case "UG":
            	location ="'"+matcher.group(3)+"'";
            	break;
            case "RI":
            	ri = new BigDecimal(123);
            	break;
            case "RF":
            	rf = new BigDecimal(123);
            	break;            	
            	
            }
        }

		
		
		List<BalanceCuentasClient> clients = clientRepository.getBalanceClients(7, "9", new BigDecimal(1000), new BigDecimal(2793520));
		return ResponseEntity.ok(clients);
	}
//	@GetMapping("/reserva/{code}")
//	public ResponseEntity<List<Client>> listarCliente(@PathVariable("code") String code) {
//		try {
//			List<Client> clients = reservaRepository.findByClientContaining(code);
//			
//			if (clients.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(clients, HttpStatus.OK);
//	    } catch (Exception e) {
//	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//		
//	}
	

}
