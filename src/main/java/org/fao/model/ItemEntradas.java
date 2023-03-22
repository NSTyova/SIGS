package org.fao.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TB_ITEM_ENTRADAS")
public class ItemEntradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private Long quantidade;
	@Column(unique = true)
	private String lote;
	private String codigo;
	private LocalDate dataFabrico;
	private LocalDate dataValidade;
	private BigDecimal gramas;
	private BigDecimal custoLotes;
	@Column(length = 50)
	private String pratileira;
	@Column(length = 50)
	private String armario;
	private boolean visibidade=true;
	private Long quantidadeActual;
	
	@ManyToOne
	@JoinColumn(name ="tipo")
	private TipoProductos tipo;
	@ManyToOne
	@JoinColumn(name ="entradas")
	private Entradas entradas;
	@ManyToOne
	@JoinColumn(name ="productos")
	private Productos productos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public BigDecimal getGramas() {
		return gramas;
	}
	public void setGramas(BigDecimal gramas) {
		this.gramas = gramas;
	}
	public BigDecimal getCustoLotes() {
		return custoLotes;
	}
	public void setCustoLotes(BigDecimal custoLotes) {
		this.custoLotes = custoLotes;
	}
	public String getPratileira() {
		return pratileira;
	}
	public void setPratileira(String pratileira) {
		this.pratileira = pratileira;
	}
	public String getArmario() {
		return armario;
	}
	public void setArmario(String armario) {
		this.armario = armario;
	}
	public TipoProductos getTipo() {
		return tipo;
	}
	public void setTipo(TipoProductos tipo) {
		this.tipo = tipo;
	}
	public Entradas getEntradas() {
		return entradas;
	}
	public void setEntradas(Entradas entradas) {
		this.entradas = entradas;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public boolean isVisibidade() {
		return visibidade;
	}
	public void setVisibidade(boolean visibidade) {
		this.visibidade = visibidade;
	}
	public Long getQuantidadeActual() {
		return quantidadeActual;
	}
	public void setQuantidadeActual(Long quantidadeActual) {
		this.quantidadeActual = quantidadeActual;
	}
	
}
