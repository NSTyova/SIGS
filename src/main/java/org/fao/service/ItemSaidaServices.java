package org.fao.service;

import org.fao.model.ItemSaida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ItemSaidaServices {

	public ItemSaida gravar(ItemSaida itemSaida);
	public ItemSaida buscarOuFalhar(Long itemSaidaId);
	public Page<ItemSaida> listar(Pageable paginacao);
	public Page<ItemSaida>  buscarPorNome(Pageable paginacao,String nome);
}
