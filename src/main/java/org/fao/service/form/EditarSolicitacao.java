package org.fao.service.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.fao.model.ItemEntradas;
import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class EditarSolicitacao {

	private Long id;
	private String estado;
	private Utilizador aprovou;
	//@JsonBackReference("role")
	private List<ItemSolicitacao> item = new ArrayList<ItemSolicitacao>();
	private Long idSolicitacao;
	
	public EditarSolicitacao() {
		super();
	}
	public EditarSolicitacao(Solicitacao solicitacao) {
		this.id=solicitacao.getId();
		this.estado = solicitacao.getEstado();
		this.aprovou=solicitacao.getAprovou();
		this.item=solicitacao.getItem();
		this.idSolicitacao=solicitacao.getId();
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
	public void setItem(List<ItemSolicitacao> item) {
		this.item = item;
	}
	public List<ItemSolicitacao> getItem() {
		return item;
	}
	
	public void setIdSolicitacao(Long idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}
}
