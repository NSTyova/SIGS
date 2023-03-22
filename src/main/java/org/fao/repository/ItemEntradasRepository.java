package org.fao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.fao.model.ItemEntradas;
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
}
