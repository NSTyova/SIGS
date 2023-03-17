package org.fao.service.impl;

import java.util.Optional;

import org.fao.model.Productos;
import org.fao.model.exception.ProductosNaoEncontradoException;
import org.fao.repository.ProductosRepository;
import org.fao.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	private ProductosRepository repository;

	@Override
	public Productos gravar(Productos productos) {
		return repository.save(productos);
	}
	

	@Override
	public Productos buscarOuFalhar(Long productosId) {
		return repository.findById(productosId).orElseThrow(() -> new ProductosNaoEncontradoException(productosId));
	}

	@Override
	public Page<Productos> listar(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Productos> buscarPorCodigo(Pageable paginacao, String nome) {
		return null;//repository.findByCodigo(paginacao, nome);
				
	}


	@Override
	public Optional<Productos> buscarCodigo(String codigo) {
		return null;
		//return repository.findByCodigo(codigo);
	}



}
