package org.fao.service.impl;

import org.fao.model.Saidas;
import org.fao.service.SaidasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaidaServiceImpl implements SaidasService{

	@Override
	public Saidas gravar(Saidas saidas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Saidas buscarOuFalhar(Long saidasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Saidas> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Saidas> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
