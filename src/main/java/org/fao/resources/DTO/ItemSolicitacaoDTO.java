package org.fao.resources.DTO;

import java.math.BigDecimal;

import org.fao.model.ItemSolicitacao;
import org.fao.model.Productos;
import org.fao.model.Solicitacao;
import org.fao.model.TipoProductos;
import org.springframework.data.domain.Page;

public class ItemSolicitacaoDTO {

	private Long id;
	private BigDecimal gramas;
	private Long quantidade;
	private Solicitacao solicitacao ;
	private Productos productos;
	private TipoProductos tipo;
	
	
	
	public ItemSolicitacaoDTO (ItemSolicitacao item) {
		this.id=item.getId();
		this.solicitacao=item.getSolicitacao();
		this.gramas=item.getGramas();
		this.quantidade=item.getQuantidade();
		this.productos=item.getProductos();
		this.tipo=item.getTipo();
		
	}
	
	

	public static Page<ItemSolicitacaoDTO> convert(Page<ItemSolicitacao> entrada) {
		return entrada.map(ItemSolicitacaoDTO::new);
	}

	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public Long getId() {
		return id;
	}



	public BigDecimal getGramas() {
		return gramas;
	}



	public Long getQuantidade() {
		return quantidade;
	}



	public Productos getProductos() {
		return productos;
	}



	public TipoProductos getTipo() {
		return tipo;
	}

	
}
