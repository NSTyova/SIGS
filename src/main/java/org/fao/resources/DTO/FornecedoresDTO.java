package org.fao.resources.DTO;

import org.fao.model.Fornecedores;
import org.springframework.data.domain.Page;

public class FornecedoresDTO {

	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private boolean estado;
	public FornecedoresDTO (Fornecedores fornecedores) {
		this.id=fornecedores.getId();
		this.nome=fornecedores.getNome();
		this.telefone=fornecedores.getTelefone();
		this.email=fornecedores.getEmail();
		this.estado=fornecedores.isEstado();
		}
	public FornecedoresDTO() {
	}
	
	public static Page<FornecedoresDTO> convert(Page<Fornecedores> fornecedores) {

		return fornecedores.map(FornecedoresDTO::new);
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public boolean isEstado() {
		return estado;
	}
	
	
}
