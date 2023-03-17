package org.fao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_TRANSFERENCIA")
public class ItemTransferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String codigo;
	@Column(unique = true)
	private String lote;
	private String quantidade;
	private String armario;
	private String pratileira;
	private boolean visibidade;
	@ManyToOne
	@JoinColumn(name = "productos")
	private Productos productos;

	@ManyToOne
	@JoinColumn(name = "transferencia")
	private Transferencia transferencia;
	
	@ManyToOne
	@JoinColumn(name = "deposito")
	private Deposito deposito;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getArmario() {
		return armario;
	}

	public void setArmario(String armario) {
		this.armario = armario;
	}

	public String getPratileira() {
		return pratileira;
	}

	public void setPratileira(String pratileira) {
		this.pratileira = pratileira;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
}
