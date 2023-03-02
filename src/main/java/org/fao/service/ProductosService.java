package org.fao.service;

import java.util.Optional;

import org.fao.model.Productos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductosService {

	public Productos gravar(Productos productos);
	public Productos buscarOuFalhar(Long productosId);
	public Page<Productos> listar(Pageable paginacao);
	public Page<Productos>  buscarPorCodigo(Pageable paginacao,String codigo);
	public Optional<Productos> buscarCodigo(String codigo); 
	
}
