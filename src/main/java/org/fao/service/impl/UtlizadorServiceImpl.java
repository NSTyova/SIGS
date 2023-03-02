package org.fao.service.impl;

import javax.transaction.Transactional;

import org.fao.model.Utilizador;
import org.fao.model.exception.CategoriasNaoEncontradoException;
import org.fao.repository.UtilizadorRepository;
import org.fao.service.UtlizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtlizadorServiceImpl implements UtlizadorService{
	
	@Autowired
	private UtilizadorRepository repository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	public Utilizador gravar(Utilizador u) {
		u.setSenha(passwordEncoder.encode(u.getPassword()));
		return repository.save(u);
	}

	@Override
	public Utilizador buscarOuFalhar(Long uId) {
		// TODO Auto-generated method stub
		return repository.findById(uId).orElseThrow(() -> new CategoriasNaoEncontradoException(uId));
	}

	@Override
	public Page<Utilizador> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Utilizador> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void alterarSenha(Long utId, String senhaActual, String novaSenha) {
		// TODO Auto-generated method stub
		Utilizador utilizador = buscarOuFalhar(utId);
		if(!passwordEncoder.matches(senhaActual, utilizador.getPassword())) {
			//throw new Ne
			// PASSAR AQUI UMA EXCPECAO PARA INFORMAR QUE AS SENHA NAO SAO IUGUAS
		}
		utilizador.setSenha(passwordEncoder.encode(novaSenha));
	}

}
