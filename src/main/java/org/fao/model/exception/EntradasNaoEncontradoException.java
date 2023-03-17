package org.fao.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntradasNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public EntradasNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public EntradasNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de entradas com código %d", cateogriasId));
	}
	
}
