package org.fao.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UtilizadorNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public UtilizadorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UtilizadorNaoEncontradoException(Long uId) {
		this(String.format("Não existe um cadastro de utilizador com código %d", uId));
	}
	
}
