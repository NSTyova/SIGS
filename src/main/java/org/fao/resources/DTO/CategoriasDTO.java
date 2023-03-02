package org.fao.resources.DTO;

import org.fao.model.Categorias;
import org.springframework.data.domain.Page;

public class CategoriasDTO {

	private Long id;
	private String descricao;
	private boolean estado;
	public CategoriasDTO (Categorias categorias) {
		this.id=categorias.getId();
		this.descricao=categorias.getDescricao();
		this.estado=categorias.isEstado();
		}
	public CategoriasDTO() {
	}
	
	public static Page<CategoriasDTO> convert(Page<Categorias> categorias) {

		return categorias.map(CategoriasDTO::new);
	}
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public boolean isEstado() {
		return estado;
	}
	
	
}
