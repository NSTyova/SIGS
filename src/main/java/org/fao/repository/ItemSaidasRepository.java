package org.fao.repository;

import org.fao.model.ItemSaida;
import org.fao.service.projections.EntradasSaidasProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemSaidasRepository extends JpaRepository<ItemSaida, Long>{

	@Query("SELECT COUNT(DISTINCT s.id) as saidas,"
			+ " (SELECT COUNT(e) FROM Entradas e INNER JOIN e.deposito d "
			+ " WHERE d.id=:deposito)  as entradas"
			+ " FROM ItemSaida its INNER JOIN its.saidas s "
			+ "	INNER JOIN  its.deposito dd "
			+ " WHERE dd.id=: deposito")
	public EntradasSaidasProjections entradasSaidas(@Param("deposito")Long deposito);
	
}
