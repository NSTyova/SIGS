package org.fao.service;

import java.time.LocalDate;
import java.util.List;

import org.fao.model.ItemEntradas;
import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.service.form.EditarSolicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SolicitacaoService {

	public Solicitacao gravar(Solicitacao solicitacao);
	public Solicitacao buscarOuFalhar(Long solicitacaoId);
	public Page<Solicitacao> listar(Pageable paginacao);
	public Page<Solicitacao>  buscarPorNome(Pageable paginacao,String nome);
	public Solicitacao editar(Long id, EditarSolicitacao solicitacao);
	// BUSCAR POR ID SOLICITACAO PENDENTE E CANCELADOS
	public List<ItemSolicitacao> buscarPorId(List<Solicitacao> dto);
	
	// BUSCAR POR ID SOLICITACAO APROVAS
	public List<ItemSolicitacao> buscarPorAprovados(List<Solicitacao> dto);
	
	// LISTAR OS APROVADOS
	public Page<Solicitacao> listarAprovados(Pageable paginacao);
	
	// BUSCAR AS SOLICATACOES POR ESTADOS E INTVERVALO DE DADOS
	public List<Solicitacao> buscarPorEstadosDatas(String estado, LocalDate dataEntrada, LocalDate dataFim);
	
}
