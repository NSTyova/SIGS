package org.fao.service;

import org.fao.model.ItemEntradas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ItemEntradasService {
	public ItemEntradas gravar(ItemEntradas itemEntradas);
	public ItemEntradas buscarOuFalhar(Long itemEntradaId);
	public Page<ItemEntradas> listar(Pageable paginacao);
	public Page<ItemEntradas>  buscarPorNome(Pageable paginacao,String nome);
}
