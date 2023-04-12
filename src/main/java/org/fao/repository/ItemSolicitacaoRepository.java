package org.fao.repository;

import java.util.List;

import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.service.projections.ProductoMaisSolicitados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemSolicitacaoRepository  extends JpaRepository<ItemSolicitacao, Long>{

	
	@Query("SELECT it FROM ItemSolicitacao it WHERE it.solicitacao = :solicitacao "
			+ " and it.visibidade=true ")
	List<ItemSolicitacao> findByIdIn( @Param("solicitacao") List<Solicitacao> solicitacao);
	
	@Query("SELECT i FROM  ItemSolicitacao i  where i.visibidade=true")
	Page<ItemSolicitacao> listar(Pageable paginacao);
	
	@Query("SELECT it FROM ItemSolicitacao it WHERE it.solicitacao = :solicitacao and "
			+ " it.visibidade=true and it.solicitacao.estado like 'Aprovada'")
	List<ItemSolicitacao> findAprovados( @Param("solicitacao") List<Solicitacao> solicitacao);
	

	@Query(value="SELECT  p.nome AS productos, COUNT(*) AS qtd "
			+ " FROM tb_item_solicitacao s "
			+ " INNER JOIN tb_productos p ON s.productos = p.id_producto "
			+ " INNER JOIN tb_solicitacao ss on s.solicitacao=ss.id "
			+ " INNER  JOIN tb_utilizador u ON (ss.solicitante =u.id) "
			+ " WHERE u.email  like :utlizador "
			+ " GROUP BY p.nome "
			+ " ORDER BY qtd DESC ", nativeQuery=true)
	public List<ProductoMaisSolicitados> productosMSolicitados(String utlizador);
	
}
