package org.fao.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemEntradasNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ItemEntradasNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ItemEntradasNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de item entradas com código %d", cateogriasId));
	}
	
}
