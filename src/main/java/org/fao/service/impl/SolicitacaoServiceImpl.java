package org.fao.service.impl;

import java.util.List;

import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;
import org.fao.model.exception.EntradasNaoEncontradoException;
import org.fao.model.exception.SolicitacaoNaoEncontradoException;
import org.fao.repository.SolicitacaoRepository;
import org.fao.service.SolicitacaoService;
import org.fao.service.form.EditarSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService{

	
	@Autowired
	private SolicitacaoRepository repository;
	
	@Override
	public Solicitacao gravar(Solicitacao solicitacao) {
		
		// GRAVAR O ID QUE VEM NA ENTRADA NO ITEM-SOLICIATACAO
		List<ItemSolicitacao> iten = solicitacao.getItem();
		iten.forEach(s -> s.setSolicitacao(solicitacao));
		
		return repository.save(solicitacao);
	}

	@Override
	public Solicitacao buscarOuFalhar(Long solicitacaoId) {
		// TODO Auto-generated method stub
		return repository.findById(solicitacaoId).orElseThrow(() -> new SolicitacaoNaoEncontradoException(solicitacaoId));
	}

	@Override
	public Page<Solicitacao> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Solicitacao> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solicitacao editar(Long id, EditarSolicitacao solicitacao) {
		Solicitacao s =repository.getById(id);
		solicitacao.setEstado(s.getEstado());
		
		return repository.save(s);
	}

}
