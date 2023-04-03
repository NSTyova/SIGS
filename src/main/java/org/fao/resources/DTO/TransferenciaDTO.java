package org.fao.resources.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.fao.model.ItemTransferencia;
import org.fao.model.Transferencia;
import org.springframework.data.domain.Page;

public class TransferenciaDTO {

	private Long id;
	private String origem;
	private String destino;
	private LocalDate dataRegistro;
	
	public TransferenciaDTO (Transferencia transferencia) {
		this.id=transferencia.getId();
		this.destino=transferencia.getDestino().getDescricao();
		this.origem=transferencia.getDestino().getDescricao();
		this.dataRegistro=transferencia.getDataTransferencia();
		
	}
	
	public static Page<TransferenciaDTO> convert(Page<Transferencia> transferenia) {
		return transferenia.map(TransferenciaDTO::new);
	}

	public Long getId() {
		return id;
	}
	public String getOrigem() {
		return origem;
	}
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	public String getDestino() {
		return destino;
	}
}
