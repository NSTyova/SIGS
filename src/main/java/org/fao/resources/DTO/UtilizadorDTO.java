package org.fao.resources.DTO;

import java.time.LocalDate;

import org.fao.model.Utilizador;
import org.springframework.data.domain.Page;

public class UtilizadorDTO {

	private Long id;
	private String username;
	private String name;
	private LocalDate dataRegister;
	public UtilizadorDTO (Utilizador u) {
		this.id=u.getId();
		this.username=u.getUsername();
		this.name=u.getName();
		this.dataRegister=u.getDataRegister();
		}
	public UtilizadorDTO() {
	}
	public static Page<UtilizadorDTO> convert(Page<Utilizador> u) {
		return u.map(UtilizadorDTO::new);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDataRegister() {
		return dataRegister;
	}
	public void setDataRegister(LocalDate dataRegister) {
		this.dataRegister = dataRegister;
	}
	
	
}
