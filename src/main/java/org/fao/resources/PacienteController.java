package org.fao.resources;

import java.util.Optional;

import org.fao.model.Paciente;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.PacienteNaoEncontradoException;
import org.fao.resources.DTO.PacienteDTO;
import org.fao.service.PacienteService;
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
@RequestMapping("/paciente")
@CrossOrigin("*")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@GetMapping
	public Page<PacienteDTO> listar(@RequestParam(required = false) String bilhete, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (bilhete == null) {
			Page<Paciente> pacientes = service.listar(paginacao);
			return PacienteDTO.convert(pacientes);
		} else {
			Page<Paciente> pacientes = service.buscarPorNome(paginacao, bilhete);
			return PacienteDTO.convert(pacientes);
		}
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente adicionar(@RequestBody Paciente pacientes) {
		try {
		
			return service.gravar(pacientes);
		} catch (PacienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{pacientesId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Paciente atualizar(@PathVariable Long pacientesId, @RequestBody Paciente pacientes) {
		try {
			Paciente clienteActual = service.buscarOuFalhar(pacientesId);
			BeanUtils.copyProperties(pacientes, clienteActual);
			return service.gravar(clienteActual);
		} catch (PacienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	
	@GetMapping("/{pacientesId}")
	public Paciente buscar(@PathVariable Long pacientesId) {
		return service.buscarOuFalhar(pacientesId);
	}
	
	@GetMapping(value = "/buscar")
	public Optional<Paciente> buscarPorBilhete( String bilhete) { 
		return service.buscarBilhete(bilhete);
	}
}
