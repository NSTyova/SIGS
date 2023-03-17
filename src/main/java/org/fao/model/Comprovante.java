package org.fao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class Comprovante {
/*
	
	private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "estoque")
	private Estoque estoque;

	// TABELA INTERMEDIA PARA GRAVAR A LISTA DE PRODUCTOS
	@ManyToMany
	@JoinTable(name = "tb_producto_comprovante", joinColumns = @JoinColumn(name = "comprovante_id"), 
						inverseJoinColumns = @JoinColumn(name = "producto_id"))
	private List<Productos> productos;

	@ManyToMany(mappedBy = "comprovante", cascade = CascadeType.ALL)
	private List<ItemComprovante> itemComprovante = new ArrayList<ItemComprovante>();
	private boolean estado = true;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public List<Productos> getProductos() {
		return productos;
	}
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	public List<ItemComprovante> getItemComprovante() {
		return itemComprovante;
	}
	public void setItemComprovante(List<ItemComprovante> itemComprovante) {
		this.itemComprovante = itemComprovante;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	*/
}
