package org.fao.service.impl;

import java.util.Optional;

import org.fao.model.Paciente;
import org.fao.model.exception.PacienteNaoEncontradoException;
import org.fao.repository.PacienteRepository;
import org.fao.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteRepository repository;

	@Override
	public Paciente gravar(Paciente paciente) {
		return repository.save(paciente);
	}

	@Override
	public Paciente buscarOuFalhar(Long pacienteId) {
		return repository.findById(pacienteId).orElseThrow(() -> new PacienteNaoEncontradoException(pacienteId));
	}

	@Override
	public Page<Paciente> listar(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Paciente> buscarPorNome(Pageable paginacao, String bilhete) {
		return  null;//repository.findByBilhete(bilhete);
	}

	@Override
	public Optional<Paciente> buscarBilhete(String bilhete) {
		return repository.findByBilhete(bilhete);
	}

}
