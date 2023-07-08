package org.fao.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_ENTRADAS")
public class Entradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal custo;
	private LocalDate dataEntrada= LocalDate.now();
	private String tipoEntrada;
	private boolean visibidade = true;
	
	@Transient
	private Long transferencia;
	
	private String emailUtilizador;
	
	@ManyToOne
	@JoinColumn(name = "utilizador")
	private Utilizador utilizador;
	@ManyToOne
	@JoinColumn(name = "depisoto")
	private Deposito deposito;
	@ManyToOne
	@JoinColumn(name = "fornecedores")
	private Fornecedores fornecedores;
	
	@ManyToMany(mappedBy = "entradas", cascade = CascadeType.ALL)
	@JsonBackReference("role")
	private List<ItemEntradas> iten = new ArrayList<ItemEntradas>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getTipoEntrada() {
		return tipoEntrada;
	}
	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	public Deposito getDeposito() {
		return deposito;
	}
	public void setDepisoto(Deposito deposito) {
		this.deposito = deposito;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	public List<ItemEntradas> getIten() {
		return iten;
	}
	public void setIten(List<ItemEntradas> iten) {
		this.iten = iten;
	}
	public Long getTransferencia() {
		return transferencia;
	}
	public void setTransferencia(Long transferencia) {
		this.transferencia = transferencia;
	}
	
	public String getEmailUtilizador() {
		return emailUtilizador;
	}
	public void setEmailUtilizador(String emailUtilizador) {
		this.emailUtilizador = emailUtilizador;
	}
	
}
