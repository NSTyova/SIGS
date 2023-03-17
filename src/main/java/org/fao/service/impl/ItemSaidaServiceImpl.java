package org.fao.service.impl;

import org.fao.model.ItemSaida;
import org.fao.service.ItemSaidaServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemSaidaServiceImpl implements ItemSaidaServices{

	@Override
	public ItemSaida gravar(ItemSaida itemSaida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemSaida buscarOuFalhar(Long itemSaidaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemSaida> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemSaida> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
