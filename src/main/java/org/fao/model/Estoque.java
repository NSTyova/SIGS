package org.fao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class Estoque {
/*
	private Long id;
	private Long quantidade;
	@Column(name = "data_registro")
	private LocalDate dataRegistro=LocalDate.now();
	
	private Servicos paciente;
	//@ManyToMany(mappedBy = "estoque", cascade = CascadeType.ALL)
	// PERMITE USAR A CLASSE SEM NECESSARIAMENTE TER DE PASSAR O JSON DELA
	//	@JsonBackReference("role")
	private List<Comprovante> comprovantes = new ArrayList<Comprovante>();
	//@Enumerated(EnumType.STRING)
	private Estado estado = Estado.ENTREGUE;
	
	
	private Utilizador utilizador;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Servicos getPaciente() {
		return paciente;
	}
	public void setPaciente(Servicos paciente) {
		this.paciente = paciente;
	}
	public List<Comprovante> getComprovantes() {
		return comprovantes;
	}
	public void setComprovantes(List<Comprovante> comprovantes) {
		this.comprovantes = comprovantes;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Utilizador getUtilizador() {
		return utilizador;
	}
	
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}*/
}
