package org.fao.service;

import java.util.List;

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
	public List<ItemSolicitacao> buscarPorId(List<Solicitacao> dto);
}
