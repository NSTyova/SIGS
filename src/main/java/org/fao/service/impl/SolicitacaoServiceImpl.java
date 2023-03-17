package org.fao.service.impl;

import org.fao.model.Solicitacao;
import org.fao.service.SolicitacaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService{

	@Override
	public Solicitacao gravar(Solicitacao solicitacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solicitacao buscarOuFalhar(Long solicitacaoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Solicitacao> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Solicitacao> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
