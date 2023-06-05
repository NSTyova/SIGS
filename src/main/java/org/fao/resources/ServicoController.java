package org.fao.resources;

import javax.validation.Valid;

import org.fao.model.Servicos;
import org.fao.model.exception.DepositoNaoEncontradoException;
import org.fao.model.exception.NegocioException;
import org.fao.resources.DTO.ServicosDTO;
import org.fao.service.ServicosService;
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
@RequestMapping("/servicos")
@CrossOrigin("*")
public class ServicoController {

	@Autowired
	private ServicosService service;

	//@PreAuthorize("isAuthenticated(EDITAR_UTILIZADOR)")
	@GetMapping
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Page<ServicosDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Servicos> servicos = service.listar(paginacao);
			return ServicosDTO.convert(servicos);
		} else {
			Page<Servicos> servicos = service.buscarPorNome(paginacao, nome);
			return ServicosDTO.convert(servicos);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Servicos adicionar(@RequestBody @Valid Servicos servicos) {
		try {
			return service.gravar(servicos);
		} catch (DepositoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{depositoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Servicos atualizar(@PathVariable Long depositoId, @RequestBody Servicos servicos) {
		try {
			Servicos depositoActual = service.buscarOuFalhar(depositoId);
			BeanUtils.copyProperties(servicos, depositoActual);
			return service.gravar(depositoActual);
		} catch (DepositoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{depositoId}")
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Servicos buscar(@PathVariable Long depositoId) {
		return service.buscarOuFalhar(depositoId);
	}
}
