package org.fao.resources.DTO;

import org.fao.model.Deposito;
import org.springframework.data.domain.Page;

public class DepositoDTO {

	private Long id;
	private String descricao;
	private String localizacao;
	public DepositoDTO (Deposito deposito) {
		this.id=deposito.getId();
		this.descricao=deposito.getDescricao();
		this.localizacao=deposito.getLocalizacao();
		}
	public DepositoDTO() {
	}
	
	public static Page<DepositoDTO> convert(Page<Deposito> deposito) {
		return deposito.map(DepositoDTO::new);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
}
