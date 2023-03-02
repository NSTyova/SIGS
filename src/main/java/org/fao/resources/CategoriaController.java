package org.fao.resources;

import javax.validation.Valid;

import org.fao.model.Categorias;
import org.fao.model.exception.CategoriasNaoEncontradoException;
import org.fao.model.exception.NegocioException;
import org.fao.resources.DTO.CategoriasDTO;
import org.fao.service.CategoriasService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriasService service;

	//@PreAuthorize("isAuthenticated(EDITAR_UTILIZADOR)")
	@GetMapping
	public Page<CategoriasDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Categorias> categorias = service.listar(paginacao);
			return CategoriasDTO.convert(categorias);
		} else {
			Page<Categorias> categorias = service.buscarPorNome(paginacao, nome);
			return CategoriasDTO.convert(categorias);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categorias adicionar(@RequestBody @Valid Categorias categorias) {
		try {
			return service.gravar(categorias);
		} catch (CategoriasNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{categoriasId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Categorias atualizar(@PathVariable Long categoriasId, @RequestBody Categorias categorias) {
		try {
			Categorias clienteActual = service.buscarOuFalhar(categoriasId);
			BeanUtils.copyProperties(categorias, clienteActual);
			return service.gravar(clienteActual);
		} catch (CategoriasNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{categoriasId}")
	public Categorias buscar(@PathVariable Long categoriasId) {
		return service.buscarOuFalhar(categoriasId);
	}
}
