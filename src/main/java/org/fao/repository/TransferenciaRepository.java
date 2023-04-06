package org.fao.repository;

import org.fao.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
	
	@Query("SELECT t FROM Transferencia t")
	Page<Transferencia>listarAprovados(Pageable paginacao);

}
