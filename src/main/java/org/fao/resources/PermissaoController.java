package org.fao.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permissao")
@CrossOrigin("*")
public class PermissaoController {

	/*@Autowired
	private PermissaoService service;

	@GetMapping
	public Page<PermissaoDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Permissao> categorias = service.listar(paginacao);
			return PermissaoDTO.convert(categorias);
		} else {
			Page<Permissao> categorias = service.buscarPorNome(paginacao, nome);
			return PermissaoDTO.convert(categorias);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Permissao adicionar(@RequestBody @Valid Permissao permissao) {
		try {
			return service.gravar(permissao);
		} catch (CategoriasNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{permissaoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Permissao atualizar(@PathVariable Long permissaoId, @RequestBody Permissao permissao) {
		try {
			Permissao permissaoActual = service.buscarOuFalhar(permissaoId);
			BeanUtils.copyProperties(permissao, permissaoActual);
			return service.gravar(permissaoActual);
		} catch (CategoriasNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{categoriasId}")
	public Permissao buscar(@PathVariable Long permissaoId) {
		return service.buscarOuFalhar(permissaoId);
	}*/
}
