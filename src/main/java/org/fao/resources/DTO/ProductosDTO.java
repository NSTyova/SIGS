package org.fao.resources.DTO;

import java.time.LocalDate;

import org.fao.model.Categorias;
import org.fao.model.Fornecedores;
import org.fao.model.Productos;
import org.springframework.data.domain.Page;

public class ProductosDTO {

	private Long id;
	private String nome;
	private String origem;
	private Categorias categoria;
	private LocalDate dataFabrico;
	private LocalDate dataValidade;
	private Long quantidade;
	private String codigo;
	private boolean estado;
	private Fornecedores fornecedor;

	public ProductosDTO(Productos productos) {
		this.id = productos.getId();
		this.nome = productos.getNome();
		this.origem = productos.getOrigem();
		this.categoria = productos.getCategoria();
		this.dataFabrico = productos.getDataFabrico();
		this.dataValidade = productos.getDataValidade();
		this.codigo = productos.getCodigo();
		this.quantidade = productos.getQuantidade();
		this.fornecedor = productos.getFornecedor();
		this.estado = productos.isEstado();
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

	public String getOrigem() {
		return origem;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public LocalDate getDataFabrico() {
		return dataFabrico;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean isEstado() {
		return estado;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public Fornecedores getFornecedor() {
		return fornecedor;
	}

	
}
