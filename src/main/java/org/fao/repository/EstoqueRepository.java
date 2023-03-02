package org.fao.repository;

import org.fao.model.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	@Query("SELECT v FROM Estoque v WHERE v.estado='ENTREGUE'")
	Page<Estoque> buscarPorStatusVendido(Pageable pageable);
	
	@Query("SELECT v FROM Estoque v WHERE v.estado='CANCELADA'")
	Page<Estoque> buscarPorStatusCancelado(Pageable pageable);
}
