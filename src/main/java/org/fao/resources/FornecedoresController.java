package org.fao.resources;

import org.fao.model.Fornecedores;
import org.fao.model.exception.FornecedoresNaoEncontradoException;
import org.fao.model.exception.NegocioException;
import org.fao.resources.DTO.FornecedoresDTO;
import org.fao.service.FornecedoresService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@RequestMapping("/fornecedores")
@CrossOrigin("*")
public class FornecedoresController {

	@Autowired
	private FornecedoresService service;

	@GetMapping
	@Cacheable(value="listaFornecedores") // CACHE DOS DADOS
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Page<FornecedoresDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Fornecedores> fornecedores = service.listar(paginacao);
			return FornecedoresDTO.convert(fornecedores);
		} else {
			Page<Fornecedores> fornecedores = service.buscarPorNome(paginacao, nome);
			return FornecedoresDTO.convert(fornecedores);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value="listaFornecedores", allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Fornecedores adicionar(@RequestBody Fornecedores fornecedores) {
		try {
			return service.gravar(fornecedores);
		} catch (FornecedoresNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{fornecedoresId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@CacheEvict(value="listaFornecedores", allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Fornecedores atualizar(@PathVariable Long fornecedoresId, @RequestBody Fornecedores fornecedores) {
		try {
			Fornecedores fornecedorActural = service.buscarOuFalhar(fornecedoresId);
			BeanUtils.copyProperties(fornecedores, fornecedorActural);
			return service.gravar(fornecedorActural);
		} catch (FornecedoresNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@GetMapping("/{fornecedoresId}")
	@CacheEvict(value="listaFornecedores", allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Fornecedores buscar(@PathVariable Long fornecedoresId) {
		return service.buscarOuFalhar(fornecedoresId);
	}
}
