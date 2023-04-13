package org.fao.repository;

import java.time.LocalDate;
import java.util.List;

import org.fao.model.Solicitacao;
import org.fao.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
	
	@Query("SELECT t FROM Transferencia t")
	Page<Transferencia>listarAprovados(Pageable paginacao);
	
	
	// BUSCAR AS SOLICATAÇÕES POR ESTADO E INTERVALO DE DATAS
		@Query("SELECT t "
			+ " FROM Transferencia t " 
			+ " WHERE t.dataTransferencia BETWEEN :dataInicio and :dataFim")
		public List<Transferencia> buscarDatas(Pageable paginacao, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

}
