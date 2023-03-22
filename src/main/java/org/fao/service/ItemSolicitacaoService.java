package org.fao.service;

import org.fao.model.ItemSolicitacao;
import org.fao.service.form.RemoverProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemSolicitacaoService {

	
	public ItemSolicitacao buscarOuFalhar(Long itemSolicitacaoId);
	public ItemSolicitacao removerProducto(Long id, RemoverProducto remove);
}
