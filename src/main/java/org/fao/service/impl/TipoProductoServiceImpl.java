package org.fao.service.impl;

import org.fao.model.TipoProductos;
import org.fao.model.exception.EstoqueNaoEncontradoException;
import org.fao.model.exception.TipoProductosNaoEncontradoException;
import org.fao.repository.TipoProductosRepository;
import org.fao.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TipoProductoServiceImpl implements TipoProductoService{

	@Autowired
	private TipoProductosRepository repository;
	
	@Override
	public TipoProductos gravar(TipoProductos categorias) {
		// TODO Auto-generated method stub
		return repository.save(categorias);
	}

	@Override
	public TipoProductos buscarOuFalhar(Long categoriasId) {
		// TODO Auto-generated method stub
		return repository.findById(categoriasId).orElseThrow(() -> new TipoProductosNaoEncontradoException(categoriasId));
	}

	@Override
	public Page<TipoProductos> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<TipoProductos> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
