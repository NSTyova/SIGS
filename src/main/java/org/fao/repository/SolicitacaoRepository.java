package org.fao.repository;

import java.util.List;

import org.fao.model.Solicitacao;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{
	
	@Query("SELECT s FROM Solicitacao s WHERE s.estado like 'Aprovada'")
	Page<Solicitacao>listarAprovados(Pageable paginacao);
	
	@Query("SELECT ser.nome as service, COUNT(s) as quantidade FROM Solicitacao s INNER JOIN s.servicos ser "
			+ " WHERE s.estado like 'Finalizada'"
			+ " GROUP BY ser.nome ")
	public List<SolicitacaoPorServicosProjections> solicitacaoServico();

}
