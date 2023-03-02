package org.fao.service;

import java.util.Optional;

import org.fao.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PacienteService {

	public Paciente gravar(Paciente paciente);
	public Paciente buscarOuFalhar(Long pacienteId);
	public Page<Paciente> listar(Pageable paginacao);
	public Page<Paciente>  buscarPorNome(Pageable paginacao,String nome);
	public Optional<Paciente> buscarBilhete(String bilhete);
}
