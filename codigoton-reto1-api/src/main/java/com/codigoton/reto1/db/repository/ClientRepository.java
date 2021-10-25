package com.codigoton.reto1.db.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codigoton.reto1.db.entities.Client;
import com.codigoton.reto1.dto.BalanceCuentasClient;



public interface ClientRepository extends JpaRepository<Client, Integer> {
//	SELECT c.code, c.male, c.type, c.location, c.company, c.encrypt, SUM(a.balance) balance FROM client c, account a WHERE c.id = a.client_id GROUP BY c.id ORDER BY balance DESC;

	
	@Query("SELECT new com.codigoton.reto1.dto.BalanceCuentasClient(c.id as clientId, c.code, c.male, c.type, "
			+ "c.location, c.company, c.encrypt, SUM(p.balance) as sumBalance) "
			+ "FROM Client c JOIN c.accounts p "
			+ "GROUP BY c.id ORDER BY sumBalance DESC")
	public List<BalanceCuentasClient> getBalanceClients();
	
	@Query("SELECT new com.codigoton.reto1.dto.BalanceCuentasClient(c.id as clientId, c.code, c.male, c.type, "
			+ "c.location, c.company, c.encrypt, SUM(p.balance) as sumBalance) "
			+ "FROM Client c JOIN c.accounts p "
			+ "WHERE "
			+"(:type is null or c.type = :type) "
			+"AND "
			+"(:location is null or c.location = :location) "
			+"AND "
			+"(:ri is null or p.balance > :ri) "
			+"AND "
			+"(:rf is null or p.balance < :rf) "
			+ "GROUP BY c.id ORDER BY sumBalance DESC")
	public List<BalanceCuentasClient> getBalanceClients(@Param("type") int type, 
			@Param("location") String location, @Param("ri") BigDecimal ri,
			@Param("rf") BigDecimal rf);	


}
