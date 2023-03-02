package org.fao.model.exception;

public class ProductosNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ProductosNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProductosNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de cateogrias com código %d", cateogriasId));
	}
	
}
