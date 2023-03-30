package org.fao.repository;

import java.time.LocalDate;
import java.util.List;

import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.service.projections.EntradasSaidasProjections;
import org.fao.service.projections.InventarioSaidasProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	// INVENTARIO DE SAIDAS
	@Query("SELECT its.lote as lotes, t.descricao as tipos, p.nome as productos, its.quanditade as quantidade, "
			+ " ser.nome as servico, its.armario as armario, its.pratileira as pratileira "
			+ " FROM ItemSaida its "
			+ " INNER JOIN its.saidas s"
			+ " INNER JOIN its.deposito d "
			+ " INNER JOIN its.productos p"
			+ " INNER JOIN its.tipo t "
			+ " INNER JOIN s.solicitacao so"
			+ " INNER JOIN so.servicos ser"
			+ " WHERE d.id=:deposito  and s.dataRegistro BETWEEN :dataEntrada and :dataSaidas")
	public Page<InventarioSaidasProjections> saidas(Pageable paginacao, @Param("deposito") Long deposito, @Param("dataEntrada") LocalDate dataEntrada,
												@Param("dataSaidas") LocalDate dataSaidas);
	
	
	// QUERY PARA O EXCEL
	@Query("SELECT its "
			+ " FROM ItemSaida its "
			+ " INNER JOIN its.saidas s"
			+ " INNER JOIN its.deposito d "
			+ " INNER JOIN its.productos p"
			+ " INNER JOIN its.tipo t "
			+ " INNER JOIN s.solicitacao so"
			+ " INNER JOIN so.servicos ser"
			+ " WHERE d.id=:deposito  and s.dataRegistro BETWEEN :dataInicio and :dataFim")
			public List<ItemSaida> inventarioExel(@Param("deposito") Long deposito,@Param("dataInicio") LocalDate dataInicio, 
																	  @Param("dataFim")LocalDate dataFim);
	
}
