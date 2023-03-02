package org.fao.repository;

import org.fao.model.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	@Query("SELECT e FROM Estoque e WHERE e.estado='ENTREGUE'"
			+ " and e.utilizador.nomeLogin like :utilizador "
			+ " and e.dataRegistro= CONVERT (date, GETDATE()) ")
	Page<Estoque> buscarPorStatusVendido(Pageable pageable, String utilizador);
	
	@Query("SELECT e FROM Estoque e WHERE e.estado='CANCELADA' "
			+ " and e.utilizador.nomeLogin like :utilizador "
			+ " and e.dataRegistro= CONVERT (date, GETDATE()) ")
	Page<Estoque> buscarPorStatusCancelado(Pageable pageable, String utilizador);
}
