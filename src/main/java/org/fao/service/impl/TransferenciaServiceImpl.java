package org.fao.service.impl;

import org.fao.model.Transferencia;
import org.fao.service.TransferenciaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Override
	public Transferencia gravar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transferencia buscarOuFalhar(Long transferenciaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Transferencia> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Transferencia> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
