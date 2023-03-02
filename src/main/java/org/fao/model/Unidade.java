package org.fao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_UNIDADE")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_unidade", nullable = false, unique = true)
	private String nome;
	@Column(name = "codigo", nullable = false, unique = true)
	private String codigo;
	@Column(name = "estado_unidade")
	private boolean estado;
	@Column(name = "data_registro")
	private LocalDate dataRegrito;
	@Column(name = "data_Inicio")
	private LocalDate dataInicio;
	@Column(name = "data_expiracao")
	private LocalDate dataExpeiracao;
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
