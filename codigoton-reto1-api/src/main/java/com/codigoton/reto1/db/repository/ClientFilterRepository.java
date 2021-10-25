package com.codigoton.reto1.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.codigoton.reto1.db.entities.Client;
import com.codigoton.reto1.dto.BalanceCuentasClient;

public interface ClientFilterRepository  extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client>{

}
