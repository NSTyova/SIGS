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
@Table(name = "TB_SOLICITACAO")
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataSolicitacao= LocalDate.now();
	private String estado = "Pendente";
	private boolean visibidade = true;
	@ManyToOne
	@JoinColumn(name = "solicitante")
	private Utilizador solicitante;
	@ManyToOne
	@JoinColumn(name = "aprovou")
	private Utilizador aprovou;
	@ManyToOne
	@JoinColumn(name = "servicos")
	private Servicos servicos;
	@ManyToOne
	@JoinColumn(name = "utilizador")
	private Utilizador utilizador;
	
	@ManyToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
	@JsonBackReference("role")
	private List<ItemSolicitacao> item = new ArrayList<ItemSolicitacao>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Utilizador getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Utilizador solicitante) {
		this.solicitante = solicitante;
	}
	public Utilizador getAprovou() {
		return aprovou;
	}
	public void setAprovou(Utilizador aprovou) {
		this.aprovou = aprovou;
	}
	public Servicos getServicos() {
		return servicos;
	}
	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}
	public List<ItemSolicitacao> getItem() {
		return item;
	}
	public void setItem(List<ItemSolicitacao> item) {
		this.item = item;
	}
	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	public boolean isVisibidade() {
		return visibidade;
	}
	public void setVisibidade(boolean visibidade) {
		this.visibidade = visibidade;
	}
	
}
