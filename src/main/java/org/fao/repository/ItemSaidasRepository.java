package org.fao.repository;

import java.util.List;

import org.fao.model.ItemSaida;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemSaidasRepository extends JpaRepository<ItemSaida, Long>{

	
	
}
