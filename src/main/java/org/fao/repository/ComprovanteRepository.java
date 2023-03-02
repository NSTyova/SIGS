package org.fao.repository;

import org.fao.model.Comprovante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprovanteRepository  extends JpaRepository<Comprovante, Long>{

	Comprovante getByEstoqueId(Long estoqueId);
}
