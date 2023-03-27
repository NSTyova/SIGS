package org.fao.service.tabelas;

import java.util.List;

import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.springframework.stereotype.Service;

@Service
public interface TabelasServices {

	// QUANTIDADE DE PRODUCTOS POR TIPO E LOTES
	List<ProductosPorTipoProjections> totalProductosTipos();
	
	// QUANTIDADE POR LOTES
	List<QuantidadesPorLotesProjections> quantidadePorLotes();
	
	//QUANTIDADES POR TIPOS
	public List<QuantidadesPorTiposProjections> quantidadePorTipo();
	
	// QUANTIDADE SOLICITADA POR SERVICOS
	public List<SolicitacaoPorServicosProjections> solicitacaoServico();
}
