package org.fao.service;

import org.fao.model.Servicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ServicosService {

	public Servicos gravar(Servicos servico);
	public Servicos buscarOuFalhar(Long servicoId);
	public Page<Servicos> listar(Pageable paginacao);
	public Page<Servicos>  buscarPorNome(Pageable paginacao,String nome);
}
