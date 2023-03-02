package org.fao.model.exception;

public class PacienteNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PacienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PacienteNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de cateogrias com código %d", cateogriasId));
	}
	
}
