package org.fao.service.impl;

import org.fao.model.Fornecedores;
import org.fao.model.exception.FornecedoresNaoEncontradoException;
import org.fao.repository.FornecedoresRepository;
import org.fao.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class FornecedoresServiceImpl implements FornecedoresService{
	
	@Autowired
	private FornecedoresRepository repository;

	@Override
	public Fornecedores gravar(Fornecedores fornecedores) {
		return repository.save(fornecedores);
	}

	@Override
	public Fornecedores buscarOuFalhar(Long fornecedoresId) {
		return repository.findById(fornecedoresId).orElseThrow(() -> new FornecedoresNaoEncontradoException(fornecedoresId));
	}

	@Override
	public Page<Fornecedores> listar(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Fornecedores> buscarPorNome(Pageable paginacao, String nome) {
		return null;
	}

}
