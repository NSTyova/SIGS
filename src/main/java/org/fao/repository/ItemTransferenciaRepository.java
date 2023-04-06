package org.fao.repository;

import java.util.List;

import org.fao.model.ItemTransferencia;
import org.fao.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTransferenciaRepository extends JpaRepository<ItemTransferencia, Long>{

	@Query("SELECT it FROM ItemTransferencia it WHERE it.transferencia = :solicitacao "
			+ " and it.visibidade=true ")
	List<ItemTransferencia> findByIdIn( @Param("solicitacao") List<Transferencia> solicitacao);
}
