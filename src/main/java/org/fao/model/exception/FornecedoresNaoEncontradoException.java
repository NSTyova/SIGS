package org.fao.model.exception;

public class FornecedoresNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FornecedoresNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FornecedoresNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de cateogrias com código %d", cateogriasId));
	}
	
}
