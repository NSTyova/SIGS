package org.fao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.fao.model.Entradas;
import org.fao.model.ItemEntradas;
import org.fao.model.Productos;
import org.fao.model.TipoProductos;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitadaoSaidaProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ItemEntradasRepository extends JpaRepository<ItemEntradas, Long>{

	
	@Query(" SELECT ie.armario as armario, ie.quantidadeActual as quantidadeActual, "
			+ " ie.lote as lote, ie.pratileira  as pratileira "
			+ " FROM  ItemEntradas ie INNER JOIN ie.entradas e "
			+ " INNER JOIN e.deposito d"
			+ " INNER JOIN ie.tipo t"
			+ " INNER JOIN ie.productos p "
			+ " WHERE p.id=:producto and t.id=:tipo and d.id=:deposito and ie.gramas=:gramas")
	List<SolicitadaoSaidaProjections> listaSaidas(@Param("producto") Long producto,@Param("tipo") Long tipo, 
												  @Param("deposito") Long deposito, @Param("gramas") BigDecimal gramas);

	@Query("SELECT ie FROM ItemEntradas ie "
			+ "WHERE ie.lote =:lote and ie.tipo=:tipos and "
			+ " ie.productos=:prod")
	ItemEntradas buscar(@Param("lote") String lote, @Param("prod") Productos prod, @Param("tipos") TipoProductos tipos);
	
	
	
	// BUSCAR O LOTER PARA POPULAR A ENTRADA NA SAIDA
	ItemEntradas findByLote(Entradas entradas);

	ItemEntradas findByLoteAndTipoAndProductos(String lote, Productos prod, TipoProductos tipos);
	
	
	
	@Query("SELECT p.nome as productos, t.descricao as tipoProductos,  count(ie.lote) as qdtLotes "
			+ " FROM ItemEntradas ie "
			+ " INNER JOIN ie.productos p "
			+ " INNER JOIN ie.tipo t GROUP BY p.nome, t.descricao ")
	List<ProductosPorTipoProjections> totalProductosTipos();
	
	
	@Query("SELECT ie.lote as lotes, count(ie) as quantidade "
			+ " FROM ItemEntradas ie "
			+ " GROUP BY ie.lote ")
	List<QuantidadesPorLotesProjections> quantidadeLotes();
	
	
	@Query("SELECT  t.descricao as tipos, count(ie) as quantidade "
			+ " FROM ItemEntradas ie "
			+ " INNER JOIN ie.tipo t GROUP BY  t.descricao ")
	List<QuantidadesPorTiposProjections> quantidadeTipos();
	
	
	

	
}
