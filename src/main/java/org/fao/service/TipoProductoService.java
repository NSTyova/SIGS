package org.fao.service;

import org.fao.model.TipoProductos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TipoProductoService {

	public TipoProductos gravar(TipoProductos categorias);
	public TipoProductos buscarOuFalhar(Long categoriasId);
	public Page<TipoProductos> listar(Pageable paginacao);
	public Page<TipoProductos>  buscarPorNome(Pageable paginacao,String nome); 
}
