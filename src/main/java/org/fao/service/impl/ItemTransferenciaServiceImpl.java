package org.fao.service.impl;

import org.fao.model.ItemTransferencia;
import org.fao.service.ItemTransferenciaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ItemTransferenciaServiceImpl implements ItemTransferenciaService{

	@Override
	public ItemTransferencia gravar(ItemTransferencia itemTransferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemTransferencia buscarOuFalhar(Long itemTransferenciaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemTransferencia> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemTransferencia> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
