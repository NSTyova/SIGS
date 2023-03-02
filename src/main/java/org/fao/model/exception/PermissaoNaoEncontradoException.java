package org.fao.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PermissaoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PermissaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PermissaoNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de cateogrias com código %d", cateogriasId));
	}
	
}
