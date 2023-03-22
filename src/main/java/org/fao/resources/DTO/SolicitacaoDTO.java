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
	private LocalDate dataCriacao;
	private String servicos;
	private String solicitante;
	private String estado;

	public SolicitacaoDTO(Solicitacao solicitacao) {
		this.id = solicitacao.getId();
		this.dataCriacao=solicitacao.getDataSolicitacao();
		this.servicos=solicitacao.getServicos().getNome();
		this.solicitante= solicitacao.getSolicitante().getName();
		this.estado=solicitacao.getEstado();

	}

	public static Page<SolicitacaoDTO> convert(Page<Solicitacao> entrada) {
		return entrada.map(SolicitacaoDTO::new);
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getServicos() {
		return servicos;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public String getEstado() {
		return estado;
	}



}
