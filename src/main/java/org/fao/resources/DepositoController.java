package org.fao.resources;

import javax.validation.Valid;

import org.fao.model.Deposito;
import org.fao.model.exception.TipoProductosNaoEncontradoException;
import org.fao.model.exception.DepositoNaoEncontradoException;
import org.fao.model.exception.NegocioException;
import org.fao.resources.DTO.DepositoDTO;
import org.fao.service.DepositoService;
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
@RequestMapping("/deposito")
@CrossOrigin("*")
public class DepositoController {

	@Autowired
	private DepositoService service;

	//@PreAuthorize("isAuthenticated(EDITAR_UTILIZADOR)")
	@GetMapping
	public Page<DepositoDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Deposito> deposito = service.listar(paginacao);
			return DepositoDTO.convert(deposito);
		} else {
			Page<Deposito> deposito = service.buscarPorNome(paginacao, nome);
			return DepositoDTO.convert(deposito);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Deposito adicionar(@RequestBody @Valid Deposito deposito) {
		try {
			return service.gravar(deposito);
		} catch (DepositoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{depositoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Deposito atualizar(@PathVariable Long depositoId, @RequestBody Deposito deposito) {
		try {
			Deposito depositoActual = service.buscarOuFalhar(depositoId);
			BeanUtils.copyProperties(deposito, depositoActual);
			return service.gravar(depositoActual);
		} catch (DepositoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{depositoId}")
	public Deposito buscar(@PathVariable Long depositoId) {
		return service.buscarOuFalhar(depositoId);
	}
}
