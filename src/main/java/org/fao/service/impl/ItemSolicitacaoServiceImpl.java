package org.fao.service.impl;

import org.fao.model.ItemSolicitacao;
import org.fao.model.exception.ItemSolicitacaoNaoEncontradoException;
import org.fao.model.exception.SolicitacaoNaoEncontradoException;
import org.fao.repository.ItemSolicitacaoRepository;
import org.fao.service.ItemSolicitacaoService;
import org.fao.service.form.RemoverProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemSolicitacaoServiceImpl implements ItemSolicitacaoService{

	@Autowired
	private ItemSolicitacaoRepository repository;
	
	@Override
	public ItemSolicitacao buscarOuFalhar(Long itemSolicitacaoId) {
		// TODO Auto-generated method stub
		return repository.findById(itemSolicitacaoId).orElseThrow(() -> new ItemSolicitacaoNaoEncontradoException(itemSolicitacaoId));
	}

	@Override
	public ItemSolicitacao removerProducto(Long id, RemoverProducto remove) {
		// TODO Auto-generated method stub
		ItemSolicitacao item =repository.getById(id);
		item.setVisibidade(remove.isVisibilidade());
		return repository.save(item);
	}

}
