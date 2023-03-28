package org.fao.service.tabelas;

import java.util.List;

import org.fao.service.projections.EntradasSaidasProjections;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.springframework.stereotype.Service;

@Service
public interface TabelasServices {

	// QUANTIDADE DE PRODUCTOS POR TIPO E LOTES
	List<ProductosPorTipoProjections> totalProductosTipos(Long deposito);
	
	// QUANTIDADE POR LOTES
	List<QuantidadesPorLotesProjections> quantidadePorLotes();
	
	//QUANTIDADES POR TIPOS
	public List<QuantidadesPorTiposProjections> quantidadePorTipo(Long deposito);
	
	// QUANTIDADE SOLICITADA POR SERVICOS
	public List<SolicitacaoPorServicosProjections> solicitacaoServico();
	
	
	// CARDS DE ENTRADAS E SAIDAS
	public EntradasSaidasProjections entradasSaidas(Long deposito);
}
