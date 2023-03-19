package org.fao.resources.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import org.fao.model.Solicitacao;
import org.fao.model.ItemSolicitacao;
import org.fao.model.Servicos;
import org.fao.model.Utilizador;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class SolicitacaoDTO {

	private Long id;
	private List<ItemSolicitacao> item ;//= new ArrayList<ItemSolicitacao>();
	private LocalDate dataSolicitacao;
	private String estado;
	private Utilizador solicitante;
	private Utilizador aprovou;
	private Servicos servicos;
	private Utilizador utilizador;
	
	
	
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

	public List<ItemSolicitacao> getItem() {
		return item;
	}
	
	public Long getId() {
		return id;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public String getEstado() {
		return estado;
	}

	public Utilizador getSolicitante() {
		return solicitante;
	}

	public Utilizador getAprovou() {
		return aprovou;
	}

	public Servicos getServicos() {
		return servicos;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}
	
	
	
}
