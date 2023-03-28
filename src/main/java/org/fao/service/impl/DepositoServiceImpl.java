package org.fao.service.impl;

import org.fao.model.Deposito;
import org.fao.model.exception.DepositoNaoEncontradoException;
import org.fao.repository.DepositoRepository;
import org.fao.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepositoServiceImpl implements DepositoService{
	
	@Autowired
	private DepositoRepository repository;

	@Override
	public Deposito gravar(Deposito deposito) {
		// TODO Auto-generated method stub
		return repository.save(deposito);
	}

	@Override
	public Deposito buscarOuFalhar(Long depositoId) {
		// TODO Auto-generated method stub
		return repository.findById(depositoId).orElseThrow(() -> new DepositoNaoEncontradoException(depositoId));
	}

	@Override
	public Page<Deposito> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Deposito> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
