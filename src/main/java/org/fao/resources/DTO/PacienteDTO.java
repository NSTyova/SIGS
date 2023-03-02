package org.fao.resources.DTO;

import org.fao.model.Paciente;
import org.springframework.data.domain.Page;

public class PacienteDTO {

	private Long id;
	private String nome;
	private String bilhete;
	private String telefone;
	
	public PacienteDTO (Paciente paciente) {
		this.nome=paciente.getNome();
		this.bilhete=paciente.getBilhete();
		this.telefone=paciente.getTelefone();
		this.id=paciente.getId();
	}

	public PacienteDTO() {
	}

	public static Page<PacienteDTO> convert(Page<Paciente> paciente) {

		return paciente.map(PacienteDTO::new);
	}

	public String getNome() {
		return nome;
	}

	public String getBilhete() {
		return bilhete;
	}

	public String getTelefone() {
		return telefone;
	}

	public Long getId() {
		return id;
	}
	
	
}
