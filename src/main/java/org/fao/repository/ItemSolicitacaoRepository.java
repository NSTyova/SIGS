package org.fao.repository;

import java.util.List;

import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemSolicitacaoRepository  extends JpaRepository<ItemSolicitacao, Long>{

	
	@Query("SELECT it FROM ItemSolicitacao it WHERE it.solicitacao = :solicitacao")
	List<ItemSolicitacao> findByIdIn( @Param("solicitacao") List<Solicitacao> solicitacao);
}
