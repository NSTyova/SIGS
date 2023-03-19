package org.fao.resources.DTO;

import java.time.LocalDate;

import org.fao.model.TipoProductos;
import org.fao.model.Fornecedores;
import org.fao.model.Productos;
import org.springframework.data.domain.Page;

public class ProductosDTO {

	private Long id;
	private String nome;

	public ProductosDTO(Productos productos) {
		this.id=productos.getId();
		this.nome=productos.getNome();
		
	}

	public ProductosDTO() {
	}

	public static Page<ProductosDTO> convert(Page<Productos> productos) {

		return productos.map(ProductosDTO::new);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
