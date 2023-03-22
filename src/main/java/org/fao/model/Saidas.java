package org.fao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_SAIDAS")
public class Saidas {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "solicitacao")
	private Solicitacao solicitacao;
	@ManyToOne
	@JoinColumn(name = "entradas")
	private Entradas entradas;
	private LocalDate dataRegistro = LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "utlizador")
	private Utilizador utlizador;
	private String estado = "Respondida";
	private boolean visibidade = true;
	
	@ManyToMany(mappedBy = "saidas", cascade = CascadeType.ALL)
	@JsonBackReference("role")
	private List<ItemSaida> iten = new ArrayList<ItemSaida>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	public Entradas getEntradas() {
		return entradas;
	}
	public void setEntradas(Entradas entradas) {
		this.entradas = entradas;
	}
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Utilizador getUtlizador() {
		return utlizador;
	}
	public void setUtlizador(Utilizador utlizador) {
		this.utlizador = utlizador;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<ItemSaida> getIten() {
		return iten;
	}
	public void setIten(List<ItemSaida> iten) {
		this.iten = iten;
	}
	public boolean isVisibidade() {
		return visibidade;
	}
	public void setVisibidade(boolean visibidade) {
		this.visibidade = visibidade;
	}
	
	
	
}
