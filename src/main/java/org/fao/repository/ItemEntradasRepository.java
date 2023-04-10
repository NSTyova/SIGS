package org.fao.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.fao.model.Deposito;
import org.fao.model.Entradas;
import org.fao.model.ItemEntradas;
import org.fao.model.Productos;
import org.fao.model.TipoProductos;
import org.fao.service.projections.InventarioEntradasProjections;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitadaoSaidaProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemEntradasRepository extends JpaRepository<ItemEntradas, Long> {

	@Query(" SELECT ie.armario as armario, ie.quantidadeActual as quantidadeActual, "
			+ " ie.lote as lote, ie.pratileira  as pratileira, e.id as entadas "
			+ " FROM  ItemEntradas ie INNER JOIN ie.entradas e " 
			+ " INNER JOIN e.deposito d" + " INNER JOIN ie.tipo t"
			+ " INNER JOIN ie.productos p "
			+ " WHERE p.id=:producto and t.id=:tipo and d.id=:deposito and ie.gramas=:gramas")
	List<SolicitadaoSaidaProjections> listaSaidas(@Param("producto") Long producto, @Param("tipo") Long tipo,
			@Param("deposito") Long deposito, @Param("gramas") BigDecimal gramas);

	// MEDTIDO PARA AS SAIDAS
	@Query("SELECT ie FROM ItemEntradas ie " 
			+ "WHERE ie.lote =:lote and ie.tipo=:tipos and "
			+ " ie.productos=:prod and ie.quantidadeActual > 10")
	ItemEntradas buscar(@Param("lote") String lote, @Param("prod") Productos prod, @Param("tipos") TipoProductos tipos);

	// METODO PARA FAZER O DESCONTO NAS QUANTIDADE NA QUESTAO DAS TRANSFERENCIA
	@Query("SELECT ie FROM ItemEntradas ie "
			+ " INNER JOIN ie.entradas e "
			//+ " INNER JOIN e.deposito d" 
			+ " WHERE ie.lote =:lote and ie.tipo=:tipos and "
			+ " ie.productos=:prod and e.deposito =:deposito and ie.quantidadeActual > 10")
	ItemEntradas buscarT(@Param("lote") String lote, @Param("prod") Productos prod, 	
							@Param("tipos") TipoProductos tipos, @Param("deposito") Deposito dep);

	// BUSCAR O LOTER PARA POPULAR A ENTRADA NA SAIDA
	ItemEntradas findByLote(Entradas entradas);

	ItemEntradas findByLoteAndTipoAndProductos(String lote, Productos prod, TipoProductos tipos);

	@Query("SELECT p.nome as productos, t.descricao as tipoProductos,  count(ie.lote) as qdtLotes "
			+ " FROM ItemEntradas ie " 
			+ " INNER JOIN ie.productos p " 
			+ " INNER JOIN ie.tipo t "
			+ " INNER JOIN ie.entradas e " 
			+ " INNER JOIN e.deposito d "
			+ " WHERE ie.quantidadeActual > 0  and d.id=:deposito " 
			+ " GROUP BY p.nome, t.descricao ")
	List<ProductosPorTipoProjections> totalProductosTipos(@Param("deposito") Long deposito);

	@Query("SELECT ie.lote as lotes, count(ie) as quantidade " 
			+ " FROM ItemEntradas ie "
			+ " WHERE ie.quantidadeActual > 0 " 
			+ " GROUP BY ie.lote ")
	List<QuantidadesPorLotesProjections> quantidadeLotes();

	@Query("SELECT  t.descricao as tipos, count(ie) as quantidade " 
			+ " FROM ItemEntradas ie "
			+ " INNER JOIN ie.tipo t " 
			+ " INNER JOIN ie.entradas e " 
			+ " INNER JOIN e.deposito d "
			+ " WHERE ie.quantidadeActual > 0 and d.id=:deposito " 
			+ " GROUP BY  t.descricao ")
	List<QuantidadesPorTiposProjections> quantidadeTipos(@Param("deposito") Long deposito);

	// QUERY PARA O INVENTARIO
	@Query("SELECT p.nome as productos, t.descricao as tipos, its.armario as armario,"
			+ " its.pratileira as pratileira, its.quantidade as qtdEntradas, its.lote as lotes, "
			+ " its.quantidadeActual as qtdActual, (its.quantidade - its.quantidadeActual) as qtdSaidas"
			+ " FROM ItemEntradas its " 
			+ " INNER JOIN its.entradas e " 
			+ " INNER JOIN e.deposito d "
			+ " INNER JOIN its.productos p "
			+ " INNER JOIN its.tipo t "
			+ " WHERE d.id=:deposito and e.dataEntrada BETWEEN :dataInicio and :dataFim")
	public Page<InventarioEntradasProjections> entradas(Pageable paginacao, @Param("deposito") Long deposito,
			@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

	// QUERY PARA O EXCEL
	@Query("SELECT its "
			+ " FROM ItemEntradas its " 
			+ " INNER JOIN its.entradas e " 
			+ " INNER JOIN e.deposito d "
			+ " INNER JOIN its.productos p " 
			+ " INNER JOIN its.tipo t "
			+ " WHERE d.id=:deposito and e.dataEntrada BETWEEN :dataInicio and :dataFim")
	public List<ItemEntradas> inventarioExel(@Param("deposito") Long deposito,
			@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
}
