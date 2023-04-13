package org.fao.service;

import java.time.LocalDate;
import java.util.List;

import org.fao.model.ItemSolicitacao;
import org.fao.model.ItemTransferencia;
import org.fao.model.Solicitacao;
import org.fao.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public interface TransferenciaService {

	public Transferencia gravar(Transferencia transferencia);
	public Transferencia buscarOuFalhar(Long transferenciaId);
	public Page<Transferencia> listar(Pageable paginacao);
	public Page<Transferencia>  buscarPorNome(Pageable paginacao,String nome);
	
	
	// BUSCAR POR ID TRANSFERENCA
	public List<ItemTransferencia> buscarPorId(List<Transferencia> dto);
	
	
	// BUSCAR AS Transferencia  POR INTVERVALO DE DADOS
	public List<Transferencia> buscarPorEstadosDatas(Pageable paginacao, LocalDate dataEntrada, LocalDate dataFim);
}
