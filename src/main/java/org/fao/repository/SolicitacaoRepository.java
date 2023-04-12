package org.fao.repository;

import java.util.List;

import org.fao.model.Solicitacao;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.fao.service.projections.SolicitacoaQDT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{
	
	@Query("SELECT s FROM Solicitacao s WHERE s.estado like 'Aprovada'")
	Page<Solicitacao>listarAprovados(Pageable paginacao);
	
	@Query("SELECT ser.nome as service, COUNT(s) as quantidade "
			+ " FROM Solicitacao s INNER JOIN s.servicos ser "
			+ " WHERE s.estado like 'Finalizada'"
			+ " GROUP BY ser.nome ")
	public List<SolicitacaoPorServicosProjections> solicitacaoServico();
	
	
	@Query(value="select count(*) as qtdSolicitacao , "
			+ "(select count(*) from tb_solicitacao "
			+ "INNER JOIN tb_utilizador u ON (s.solicitante =u.id) where estado='Pedente' and data_register= CONVERT(date, GETDATE())"
			+ " and  u.email like :utilizador ) as pendente, "
			+ "(select count(*) from tb_solicitacao "
			+ "INNER JOIN tb_utilizador u ON (s.solicitante =u.id) where estado='Finalizada' and data_register= CONVERT(date, GETDATE())"
			+ " and  u.email like :utilizador ) as finalizada, "
			+ "(select count(*) from tb_solicitacao INNER JOIN tb_utilizador u ON "
			+ " (s.solicitante =u.id) where estado='Aprovada' and data_register= CONVERT(date, GETDATE())"
			+ " and  u.email like :utilizador ) as aprovada "
			+ "from tb_solicitacao s "
			+ "INNER JOIN tb_utilizador u ON (s.solicitante =u.id) "
			+ "and data_register= CONVERT(date, GETDATE()) "
			+ " and  u.email like :utilizador "
			+ "group by solicitante", nativeQuery=true)
	public List<SolicitacoaQDT> limitados(String utilizador);

}
