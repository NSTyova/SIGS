package org.fao.service;

import org.fao.model.Solicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SolicitacaoService {

	public Solicitacao gravar(Solicitacao solicitacao);
	public Solicitacao buscarOuFalhar(Long solicitacaoId);
	public Page<Solicitacao> listar(Pageable paginacao);
	public Page<Solicitacao>  buscarPorNome(Pageable paginacao,String nome);
}
