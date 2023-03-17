package org.fao.resources.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.fao.model.Solicitacao;
import org.fao.model.ItemSolicitacao;
import org.fao.model.Servicos;
import org.fao.model.Utilizador;
import org.springframework.data.domain.Page;

public class SolicitacaoDTO {

	private Long id;
	private LocalDate dataSolicitacao;
	private String estado;
	private Utilizador solicitante;
	private Utilizador aprovou;
	private Servicos servicos;
	private Utilizador utilizador;
	private List<ItemSolicitacao> item = new ArrayList<ItemSolicitacao>();
	
	public SolicitacaoDTO() {
	}
	
	public SolicitacaoDTO (Solicitacao solicitacao) {
		this.id=solicitacao.getId();
		this.dataSolicitacao=solicitacao.getDataSolicitacao();
		this.solicitante=solicitacao.getSolicitante();
		this.aprovou=solicitacao.getAprovou();
		this.utilizador=solicitacao.getUtilizador();
		this.estado=solicitacao.getEstado();
		this.servicos=solicitacao.getServicos();
		this.item=solicitacao.getItem();
	}

	public static Page<SolicitacaoDTO> convert(Page<Solicitacao> entrada) {
		return entrada.map(SolicitacaoDTO::new);
	}

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

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public List<ItemSolicitacao> getItem() {
		return item;
	}

	public void setItem(List<ItemSolicitacao> item) {
		this.item = item;
	}
	
	
}
