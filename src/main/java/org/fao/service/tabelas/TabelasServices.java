package org.fao.service.tabelas;

import java.time.LocalDate;
import java.util.List;

import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.service.projections.EntradasSaidasProjections;
import org.fao.service.projections.InventarioEntradasProjections;
import org.fao.service.projections.InventarioSaidasProjections;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	
	// CARDS DE ENTRADAS E SAIDAS ACRESCENTRAR O CAMPO TRANSFERENCIA NESTE
	public EntradasSaidasProjections entradasSaidas(Long deposito);
	
	// INVENTARIO DE ENTRADA
	public Page<InventarioEntradasProjections> entradas(Pageable paginacao,Long deposito, LocalDate dataInicio, LocalDate dataFim);
	
	// INVENTARIO DE Saidas
	public Page<InventarioSaidasProjections> saidas(Pageable paginacao, Long deposito, LocalDate dataInicio, LocalDate dataFim);
	
	// EXPORTAR EXCEL PARA ENTRADAS
	List<ItemEntradas> listaExcel(Long deposito, LocalDate dataEntrada, LocalDate dataFim);
	
	// EXPORTAR EXCEL PARA ENTRADAS
	List<ItemSaida> listaExcelSaidas(Long deposito, LocalDate dataEntrada, LocalDate dataFim);
}
