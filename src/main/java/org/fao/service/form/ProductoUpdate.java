package org.fao.service.form;

import java.time.LocalDateTime;

public class ProductoUpdate {

	private Long id;
	private int qtd;
	private LocalDateTime dataRegistro;
	private LocalDateTime dataEdicao = LocalDateTime.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
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

	
	
}
