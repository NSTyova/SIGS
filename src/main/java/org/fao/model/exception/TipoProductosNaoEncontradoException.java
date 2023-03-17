package org.fao.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TipoProductosNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public TipoProductosNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public TipoProductosNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de tipo producto com código %d", cateogriasId));
	}
	
}
