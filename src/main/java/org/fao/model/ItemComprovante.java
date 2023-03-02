package org.fao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item_comprovante")

public class ItemComprovante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comprovante_id")
	private Comprovante comprovante;
	@ManyToOne
	@JoinColumn(name = "productos")
	private Productos productos;
	
	private Long quantidade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Comprovante getComprovante() {
		return comprovante;
	}
	public void setComprovante(Comprovante comprovante) {
		this.comprovante = comprovante;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
