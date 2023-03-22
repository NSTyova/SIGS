package org.fao.resources;

import java.math.BigDecimal;
import java.util.List;

import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.UtilizadorNaoEncontradoException;
import org.fao.service.ItemEntradasService;
import org.fao.service.ItemSolicitacaoService;
import org.fao.service.form.RemoverProducto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemSolicitacaoController {

	@Autowired
	private ItemSolicitacaoService service;
	
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	//@PreAuthorize("hasAnyAuthority('Editar_Usuarios')")
	public ItemSolicitacao remover(@PathVariable Long id, @RequestBody RemoverProducto remove,
			@AuthenticationPrincipal Utilizador utilizador) {
		try {
			remove.setUtilizador(utilizador);
			ItemSolicitacao solicitacao = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(remove, solicitacao);
			return service.removerProducto(id, remove);
		} catch (UtilizadorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
