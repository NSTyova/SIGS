package org.fao.service.impl;

import org.fao.model.ItemEntradas;
import org.fao.service.ItemEntradasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemEntradaServiceImpl implements ItemEntradasService{

	@Override
	public ItemEntradas gravar(ItemEntradas itemEntradas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemEntradas buscarOuFalhar(Long itemEntradaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemEntradas> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemEntradas> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
