package org.fao.resources.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.fao.model.Deposito;
import org.fao.model.Entradas;
import org.fao.model.Fornecedores;
import org.fao.model.ItemEntradas;
import org.fao.model.Utilizador;
import org.springframework.data.domain.Page;

public class EntradasDTO {

	private Long id;
	private BigDecimal custo;
	private LocalDate dataEntrada;
	private String tipoEntrada;
	private Utilizador utilizador;
	private Deposito depisoto;
	private Fornecedores fornecedores;
	private List<ItemEntradas> iten = new ArrayList<ItemEntradas>();
	
	public EntradasDTO() {
	}
	
	public EntradasDTO (Entradas entradas) {
		this.id=entradas.getId();
		this.custo=entradas.getCusto();
		this.dataEntrada=entradas.getDataEntrada();
		this.tipoEntrada=entradas.getTipoEntrada();
		this.utilizador=entradas.getUtilizador();
		this.depisoto=entradas.getDepisoto();
		this.fornecedores=entradas.getFornecedores();
		this.iten=entradas.getIten();
	}

	public static Page<EntradasDTO> convert(Page<Entradas> entrada) {
		return entrada.map(EntradasDTO::new);
	}

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

	public Deposito getDepisoto() {
		return depisoto;
	}

	public void setDepisoto(Deposito depisoto) {
		this.depisoto = depisoto;
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
	
	
}
