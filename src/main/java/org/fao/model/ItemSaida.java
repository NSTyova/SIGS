package org.fao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_SAIDAS")
public class ItemSaida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long quanditade;
	private BigDecimal gramas;
	private boolean visibidade;
	
	@ManyToOne
	@JoinColumn(name = "deposito")
	private Deposito deposito;
	@ManyToOne
	@JoinColumn(name = "saidas")
	private Saidas saidas;
	@ManyToOne
	@JoinColumn(name = "productos")
	private Productos productos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuanditade() {
		return quanditade;
	}
	public void setQuanditade(Long quanditade) {
		this.quanditade = quanditade;
	}
	public BigDecimal getGramas() {
		return gramas;
	}
	public void setGramas(BigDecimal gramas) {
		this.gramas = gramas;
	}
	public boolean isVisibidade() {
		return visibidade;
	}
	public void setVisibidade(boolean visibidade) {
		this.visibidade = visibidade;
	}
	public Deposito getDeposito() {
		return deposito;
	}
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	public Saidas getSaidas() {
		return saidas;
	}
	public void setSaidas(Saidas saidas) {
		this.saidas = saidas;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	
	
}
