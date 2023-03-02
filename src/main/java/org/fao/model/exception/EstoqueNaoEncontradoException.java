package org.fao.model.exception;

public class EstoqueNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public EstoqueNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public EstoqueNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de cateogrias com código %d", cateogriasId));
	}
	
}
