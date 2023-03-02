package org.fao.resources.DTO;

import org.fao.model.Permissao;
import org.springframework.data.domain.Page;

public class PermissaoDTO {

	private Long id;
	private String descricao;
	private String nome;
	
	public PermissaoDTO (Permissao categorias) {
		this.id=categorias.getId();
		this.descricao=categorias.getDescricao();
		this.nome=categorias.getNome();
		}
	public PermissaoDTO() {
	}
	
	public static Page<PermissaoDTO> convert(Page<Permissao> permissoes) {

		return permissoes.map(PermissaoDTO::new);
	}
	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getNome() {
		return nome;
	}
	
	
}
