package org.fao.service.impl;

import org.fao.model.Entradas;
import org.fao.service.EntradaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EntradaServiceImpl implements EntradaService{

	@Override
	public Entradas gravar(Entradas entradas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entradas buscarOuFalhar(Long entradaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Entradas> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Entradas> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
