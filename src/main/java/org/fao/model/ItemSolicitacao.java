package org.fao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_SOLICITACAO")
public class ItemSolicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal gramas;
	private Long quantidade;
	private boolean visibidade = true;
	@ManyToOne
	@JoinColumn(name = "productos")
	private Productos productos;
	@ManyToOne
	@JoinColumn(name = "tipo")
	private TipoProductos tipo;
	@ManyToOne
	@JoinColumn(name = "solicitacao")
	private Solicitacao solicitacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getGramas() {
		return gramas;
	}
	public void setGramas(BigDecimal gramas) {
		this.gramas = gramas;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isVisibidade() {
		return visibidade;
	}
	public void setVisibidade(boolean visibidade) {
		this.visibidade = visibidade;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public TipoProductos getTipo() {
		return tipo;
	}
	public void setTipo(TipoProductos tipo) {
		this.tipo = tipo;
	}
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
	@Override
	public String toString() {
		return "ItemSolicitacao [id=" + id + ", gramas=" + gramas + ", quantidade=" + quantidade + ", visibidade="
				+ visibidade + ", productos=" + productos + ", tipo=" + tipo + ", solicitacao=" + solicitacao + "]";
	}
	
	
	
}
