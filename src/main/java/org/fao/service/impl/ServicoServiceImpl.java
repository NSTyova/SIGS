package org.fao.service.impl;

import org.fao.model.Servicos;
import org.fao.service.ServicosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ServicoServiceImpl implements ServicosService{

	@Override
	public Servicos gravar(Servicos servico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicos buscarOuFalhar(Long servicoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Servicos> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Servicos> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
