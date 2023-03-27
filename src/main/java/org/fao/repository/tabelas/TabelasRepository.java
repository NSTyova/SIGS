package org.fao.repository.tabelas;

import java.util.List;

import org.fao.model.ItemEntradas;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TabelasRepository  extends JpaRepository<ItemEntradas, Long>{

	
	
	
}
