package org.fao.service.impl;

import org.fao.model.Permissao;
import org.fao.model.exception.ProductosNaoEncontradoException;
import org.fao.repository.PermissaoRepository;
import org.fao.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PermissaoServiceImpl implements PermissaoService{

	@Autowired
	private PermissaoRepository repository;
	
	
	@Override
	public Permissao gravar(Permissao permisao) {
		// TODO Auto-generated method stub
		return repository.save(permisao);
	}

	@Override
	public Permissao buscarOuFalhar(Long permisao) {
		// TODO Auto-generated method stub
		return repository.findById(permisao).orElseThrow(() -> new ProductosNaoEncontradoException(permisao));
	}

	@Override
	public Page<Permissao> listar(Pageable permisao) {
		// TODO Auto-generated method stub
		return repository.findAll(permisao);
	}

	@Override
	public Page<Permissao> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
