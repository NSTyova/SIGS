package org.fao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
	private String lote;
	private Long quantidade;
	private String armario;
	private String pratileira;
	private boolean visibidade=true;
	private BigDecimal gramas;
	private LocalDate dataFabrico;
	private LocalDate dataValidade;
	@ManyToOne
	@JoinColumn(name = "productos")
	private Productos productos;

	@ManyToOne
	@JoinColumn(name = "transferencia")
	private Transferencia transferencia;
	
	@ManyToOne
	@JoinColumn(name = "entradas")
	private Entradas entradas;
	
	@ManyToOne
	@JoinColumn(name = "tipo")
	private TipoProductos tipo;

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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
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

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	public Entradas getEntradas() {
		return entradas;
	}

	public void setEntradas(Entradas entradas) {
		this.entradas = entradas;
	}
	public TipoProductos getTipo() {
		return tipo;
	}
	public void setTipo(TipoProductos tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getGramas() {
		return gramas;
	}
	public void setGramas(BigDecimal gramas) {
		this.gramas = gramas;
	}

	public LocalDate getDataFabrico() {
		return dataFabrico;
	}

	public void setDataFabrico(LocalDate dataFabrico) {
		this.dataFabrico = dataFabrico;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
}
