package org.fao.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepositoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public DepositoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public DepositoNaoEncontradoException(Long cateogriasId) {
		this(String.format("Não existe um cadastro de deposito com código %d", cateogriasId));
	}
	
}
