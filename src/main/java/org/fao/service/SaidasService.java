package org.fao.service;

import org.fao.model.Saidas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public interface SaidasService {

	public Saidas gravar(Saidas saidas);
	public Saidas buscarOuFalhar(Long saidasId);
	public Page<Saidas> listar(Pageable paginacao);
	public Page<Saidas>  buscarPorNome(Pageable paginacao,String nome);
}
