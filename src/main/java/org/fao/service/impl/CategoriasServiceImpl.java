package org.fao.service.impl;

import org.fao.model.Categorias;
import org.fao.model.exception.CategoriasNaoEncontradoException;
import org.fao.repository.CategoriasRepository;
import org.fao.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImpl implements CategoriasService{

	@Autowired
	private CategoriasRepository repository;
	
	
	
	@Override
	public Categorias gravar(Categorias categorias) {
		// TODO Auto-generated method stub
		return repository.save(categorias);

	}

	@Override
	public Categorias buscarOuFalhar(Long categoriasId) {
		// TODO Auto-generated method stub
		return repository.findById(categoriasId).orElseThrow(() -> new CategoriasNaoEncontradoException(categoriasId));
	}

	@Override
	public Page<Categorias> listar(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Categorias> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
