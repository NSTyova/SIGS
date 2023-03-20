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
	private List<ItemSolicitacao> item ;
	
	
	
	public SolicitacaoDTO (Solicitacao solicitacao) {
		this.id=solicitacao.getId();
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

	
}
