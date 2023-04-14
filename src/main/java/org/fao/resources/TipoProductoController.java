package org.fao.resources;

import javax.validation.Valid;

import org.fao.model.TipoProductos;
import org.fao.model.exception.TipoProductosNaoEncontradoException;
import org.fao.model.exception.NegocioException;
import org.fao.resources.DTO.TipoProductoDTO;
import org.fao.service.TipoProductoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo")
@CrossOrigin("*")
public class TipoProductoController {

	@Autowired
	private TipoProductoService service;

	//@PreAuthorize("isAuthenticated(EDITAR_UTILIZADOR)")
	@GetMapping
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Page<TipoProductoDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<TipoProductos> tipo = service.listar(paginacao);
			return TipoProductoDTO.convert(tipo);
		} else {
			Page<TipoProductos> tipo = service.buscarPorNome(paginacao, nome);
			return TipoProductoDTO.convert(tipo);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public TipoProductos adicionar(@RequestBody @Valid TipoProductos tipo) {
		try {
			return service.gravar(tipo);
		} catch (TipoProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{tipoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public TipoProductos atualizar(@PathVariable Long tipoId, @RequestBody TipoProductos tipo) {
		try {
			TipoProductos tipoActual = service.buscarOuFalhar(tipoId);
			BeanUtils.copyProperties(tipo, tipoActual);
			return service.gravar(tipoActual);
		} catch (TipoProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{tipoId}")
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public TipoProductos buscar(@PathVariable Long tipoId) {
		return service.buscarOuFalhar(tipoId);
	}
}
