package org.fao.service.impl.tabelasProjections;

import java.time.LocalDate;
import java.util.List;

import org.fao.repository.ItemEntradasRepository;
import org.fao.repository.ItemSaidasRepository;
import org.fao.repository.SolicitacaoRepository;
import org.fao.service.projections.EntradasSaidasProjections;
import org.fao.service.projections.InventarioEntradasProjections;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.fao.service.tabelas.TabelasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabelasServicesImpl implements TabelasServices{

	@Autowired
	private ItemEntradasRepository repository;
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	@Autowired
	private ItemSaidasRepository itemSaidasRepository;
	
	@Override
	public List<ProductosPorTipoProjections> totalProductosTipos(Long deposito) {
		// TODO Auto-generated method stub
		return repository.totalProductosTipos(deposito);
	}

	@Override
	public List<QuantidadesPorLotesProjections> quantidadePorLotes() {
		// TODO Auto-generated method stub
		return repository.quantidadeLotes();
	}
	
	@Override
	public List<QuantidadesPorTiposProjections> quantidadePorTipo(Long deposito ) {
		// TODO Auto-generated method stub
		return repository.quantidadeTipos(deposito);
	}

	@Override
	public List<SolicitacaoPorServicosProjections> solicitacaoServico() {
		// TODO Auto-generated method stub
		return solicitacaoRepository.solicitacaoServico();
	}

	@Override
	public EntradasSaidasProjections entradasSaidas(Long deposito) {
		// TODO Auto-generated method stub
		return itemSaidasRepository.entradasSaidas(deposito);
	}

	@Override
	public List<InventarioEntradasProjections> entradas(Long deposito, LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		return repository.entradas(deposito, dataInicio, dataFim);
	}

}
