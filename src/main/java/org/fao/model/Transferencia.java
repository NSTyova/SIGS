package org.fao.model;

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

@Entity
@Table(name = "TB_TRANSFERENCIA")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataTransferencia;
	private boolean visibidade=true;
	@ManyToOne
	@JoinColumn(name = "entradas")
	private Entradas entradas;
	
	@ManyToOne
	@JoinColumn(name = "utilizador")
	private Utilizador utilizador;
	
	@ManyToMany(mappedBy = "transferencia", cascade = CascadeType.ALL)
	private List<ItemTransferencia> iten = new ArrayList<ItemTransferencia>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public Entradas getEntradas() {
		return entradas;
	}
	public void setEntradas(Entradas entradas) {
		this.entradas = entradas;
	}
	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	public List<ItemTransferencia> getIten() {
		return iten;
	}
	public void setIten(List<ItemTransferencia> iten) {
		this.iten = iten;
	}
	
	
}
