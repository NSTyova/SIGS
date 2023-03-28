package org.fao.service.impl.tabelasProjections;

import java.util.List;

import org.fao.repository.ItemEntradasRepository;
import org.fao.repository.ItemSaidasRepository;
import org.fao.repository.SolicitacaoRepository;
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
	
	@Override
	public List<ProductosPorTipoProjections> totalProductosTipos() {
		// TODO Auto-generated method stub
		return repository.totalProductosTipos();
	}

	@Override
	public List<QuantidadesPorLotesProjections> quantidadePorLotes() {
		// TODO Auto-generated method stub
		return repository.quantidadeLotes();
	}
	
	@Override
	public List<QuantidadesPorTiposProjections> quantidadePorTipo() {
		// TODO Auto-generated method stub
		return repository.quantidadeTipos();
	}

	@Override
	public List<SolicitacaoPorServicosProjections> solicitacaoServico() {
		// TODO Auto-generated method stub
		return solicitacaoRepository.solicitacaoServico();
	}

}
