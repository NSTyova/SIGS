package org.fao.service;

import org.fao.model.Categorias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoriasService {

	public Categorias gravar(Categorias categorias);
	public Categorias buscarOuFalhar(Long categoriasId);
	public Page<Categorias> listar(Pageable paginacao);
	public Page<Categorias>  buscarPorNome(Pageable paginacao,String nome); 
}
