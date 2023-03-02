package org.fao.service;

import org.fao.model.Fornecedores;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FornecedoresService {

	public Fornecedores gravar(Fornecedores fornecedores);
	public Fornecedores buscarOuFalhar(Long fornecedoresId);
	public Page<Fornecedores> listar(Pageable paginacao);
	public Page<Fornecedores>  buscarPorNome(Pageable paginacao,String nome); 
}
