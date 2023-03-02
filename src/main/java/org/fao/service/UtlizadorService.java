package org.fao.service;

import org.fao.model.Utilizador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UtlizadorService {

	public Utilizador gravar(Utilizador u);
	public Utilizador buscarOuFalhar(Long uId);
	public Page<Utilizador> listar(Pageable paginacao);
	public Page<Utilizador>  buscarPorNome(Pageable paginacao,String nome);
	public void alterarSenha(Long utId, String senhaActual, String novaSenha);
}
