package org.fao.service;

import org.fao.model.ItemTransferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ItemTransferenciaService {

	public ItemTransferencia gravar(ItemTransferencia itemTransferencia);
	public ItemTransferencia buscarOuFalhar(Long itemTransferenciaId);
	public Page<ItemTransferencia> listar(Pageable paginacao);
	public Page<ItemTransferencia>  buscarPorNome(Pageable paginacao,String nome);
}
