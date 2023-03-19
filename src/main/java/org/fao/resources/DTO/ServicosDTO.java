package org.fao.resources.DTO;

import org.fao.model.Deposito;
import org.fao.model.Servicos;
import org.springframework.data.domain.Page;

public class ServicosDTO {

	private Long id;
	private String nome;
	public ServicosDTO (Servicos servicos) {
		this.id=servicos.getId();
		this.nome=servicos.getNome();
		}
	public ServicosDTO() {
	}
	
	public static Page<ServicosDTO> convert(Page<Servicos> servicos) {
		return servicos.map(ServicosDTO::new);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
