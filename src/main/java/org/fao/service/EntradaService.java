package org.fao.service;

import org.fao.model.Entradas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public interface EntradaService {

	public Entradas gravar(Entradas entradas);
	public Entradas buscarOuFalhar(Long entradaId);
	public Page<Entradas> listar(Pageable paginacao);
	public Page<Entradas>  buscarPorNome(Pageable paginacao,String nome);
}
