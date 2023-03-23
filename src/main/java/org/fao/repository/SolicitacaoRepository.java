package org.fao.repository;

import org.fao.model.Solicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{
	
	@Query("SELECT s FROM Solicitacao s WHERE s.estado like 'Aprovada'")
	Page<Solicitacao>listarAprovados(Pageable paginacao);

}
