package org.fao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "origem", length = 50, nullable = true)
	private String origem;
	@ManyToOne
	@JoinColumn(name = "categorias")
	private Categorias categoria;
	@ManyToOne
	@JoinColumn(name = "fornecedores")
	private Fornecedores fornecedor;
	@Column(name = "data_fabrico", nullable = true)
	private LocalDate dataFabrico;
	@Column(name = "data_validade", nullable = true)
	private LocalDate dataValidade;
	@Column(name = "codigo_producto")
	private String codigo;
	private Long quantidade =0L;
	private LocalDateTime dataRegistro = LocalDateTime.now();
	@Column(name = "dataEditacao")
	private LocalDateTime dataEdicao = LocalDateTime.now();
	private boolean estado  = true;

	public Productos() {
		
	}
	public Productos(Long id) {
		super();
		this.id = id;
	}
	/*@Transient
	private int qtd;*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public LocalDateTime getDataEdicao() {
		return dataEdicao;
	}
	public void setDataEdicao(LocalDateTime dataEdicao) {
		this.dataEdicao = dataEdicao;
	}
	
	public Fornecedores getFornecedor() {
		return fornecedor;
	}
	public void setFornecedores(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
