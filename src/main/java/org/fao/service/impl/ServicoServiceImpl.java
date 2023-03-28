package org.fao.service.impl;

import org.fao.model.Servicos;
import org.fao.model.exception.ServicosNaoEncontradoException;
import org.fao.repository.ServicosRepository;
import org.fao.service.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ServicoServiceImpl implements ServicosService{
	
	@Autowired
	private ServicosRepository repository;

	@Override
	public Servicos gravar(Servicos servico) {
		// TODO Auto-generated method stub
		return repository.save(servico);
	}

	@Override
	public Servicos buscarOuFalhar(Long servicoId) {
		// TODO Auto-generated method stub
		return repository.findById(servicoId).orElseThrow(() -> new ServicosNaoEncontradoException(servicoId));
	}

	@Override
	public Page<Servicos> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Servicos> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
