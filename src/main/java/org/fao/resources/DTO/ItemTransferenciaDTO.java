package org.fao.resources.DTO;

import java.math.BigDecimal;

import org.fao.model.ItemSolicitacao;
import org.fao.model.ItemTransferencia;
import org.fao.model.Productos;
import org.fao.model.Solicitacao;
import org.fao.model.TipoProductos;
import org.fao.model.Transferencia;
import org.springframework.data.domain.Page;

public class ItemTransferenciaDTO {

	private Long id;
	private String gramas;
	private String quantidade;
	private Transferencia transferencia;
	private Productos productos;

	public ItemTransferenciaDTO(ItemTransferencia item) {
		this.id = item.getId();
		this.transferencia = item.getTransferencia();
		this.gramas = item.getArmario();
		this.quantidade = item.getQuantidade();
		this.productos = item.getProductos();

	}

	public static Page<ItemTransferenciaDTO> convert(Page<ItemTransferencia> entrada) {
		return entrada.map(ItemTransferenciaDTO::new);
	}

	public Long getId() {
		return id;
	}

	public String getGramas() {
		return gramas;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public Productos getProductos() {
		return productos;
	}

}
