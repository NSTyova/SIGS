package org.fao.service.form;

import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;

public class EditarSolicitacao {

	private Long id;
	private String estado;
	private Utilizador aprovou;
	
	
	public EditarSolicitacao() {
		super();
	}
	public EditarSolicitacao(Solicitacao solicitacao) {
		this.id=solicitacao.getId();
		this.estado = solicitacao.getEstado();
		this.aprovou=solicitacao.getAprovou();
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Utilizador getAprovou() {
		return aprovou;
	}
	public void setAprovou(Utilizador aprovou) {
		this.aprovou = aprovou;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
