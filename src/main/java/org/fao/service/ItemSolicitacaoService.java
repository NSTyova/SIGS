package org.fao.service;

import org.fao.model.ItemSolicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemSolicitacaoService {

	public ItemSolicitacao gravar(ItemSolicitacao itemSolicitacao);
	public ItemSolicitacao buscarOuFalhar(Long itemSolicitacaoId);
	public Page<ItemSolicitacao> listar(Pageable paginacao);
	public Page<ItemSolicitacao>  buscarPorNome(Pageable paginacao,String nome);
}
