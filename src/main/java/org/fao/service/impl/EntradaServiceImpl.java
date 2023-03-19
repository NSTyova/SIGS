package org.fao.service.impl;

import java.util.List;

import org.fao.model.Entradas;
import org.fao.model.ItemEntradas;
import org.fao.model.exception.EntradasNaoEncontradoException;
import org.fao.repository.EntradasRepository;
import org.fao.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EntradaServiceImpl implements EntradaService{
	
	@Autowired
	private EntradasRepository repository;

	@Override
	public Entradas gravar(Entradas entradas) {
		
		// GRAVAR O ID QUE VEM NA ENTRADA NO ITEM-ENTRADA
		List<ItemEntradas> iten = entradas.getIten();
		iten.forEach(i -> i.setEntradas(entradas));
		
	
		return repository.save(entradas);
	}

	@Override
	public Entradas buscarOuFalhar(Long entradaId) {
		// TODO Auto-generated method stub
		 return repository.findById(entradaId).orElseThrow(() -> new EntradasNaoEncontradoException(entradaId));
	}

	@Override
	public Page<Entradas> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Entradas> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
