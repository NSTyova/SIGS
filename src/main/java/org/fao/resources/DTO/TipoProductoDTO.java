package org.fao.resources.DTO;

import org.fao.model.TipoProductos;
import org.springframework.data.domain.Page;

public class TipoProductoDTO {

	private Long id;
	private String descricao;
	private boolean estado;
	public TipoProductoDTO (TipoProductos tipo) {
		this.id=tipo.getId();
		this.descricao=tipo.getDescricao();
		this.estado=tipo.isEstado();
		}
	public TipoProductoDTO() {
	}
	
	public static Page<TipoProductoDTO> convert(Page<TipoProductos> tipo) {

		return tipo.map(TipoProductoDTO::new);
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
