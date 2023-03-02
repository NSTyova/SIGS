package org.fao.service;

import org.fao.model.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EstoqueService {

	public Estoque gravar(Estoque estoque);
	public Estoque buscarOuFalhar(Long estoqueId);
	public Page<Estoque> listarVendidas(Pageable paginacao,String utilizador);
	public Page<Estoque> listarCanceladas(Pageable paginacao, String utilizador);
		
	public Estoque cancel(Estoque estoque);
	
	
}
