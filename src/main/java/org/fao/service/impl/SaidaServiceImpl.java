package org.fao.service.impl;

import java.util.List;

import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.model.Productos;
import org.fao.model.Saidas;
import org.fao.model.Solicitacao;
import org.fao.model.TipoProductos;
import org.fao.repository.ItemEntradasRepository;
import org.fao.repository.ProductosRepository;
import org.fao.repository.SaidasRepository;
import org.fao.repository.SolicitacaoRepository;
import org.fao.repository.TipoProductosRepository;
import org.fao.service.SaidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaidaServiceImpl implements SaidasService {

	@Autowired
	private SaidasRepository repository;

	@Autowired
	private ItemEntradasRepository itemEntradasRepository;
	
	@Autowired
	private TipoProductosRepository tipoProductosRepository;
	
	@Autowired
	private  ProductosRepository entradasRepository;
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	@Override
	public Saidas gravar(Saidas saidas) {

		// GRAVAR O ID QUE VEM NA SAIDA E GRAVAR NO ITEM-SAIDAS
		List<ItemSaida> iten = saidas.getIten();
		iten.forEach(s -> s.setSaidas(saidas));

		
		// PEGAR O PRODUCTO, TIPO, LOTE
		for(ItemSaida itemSaida : saidas.getIten()) {
			
			Long tipo = itemSaida.getTipo().getId();
			TipoProductos tipos = tipoProductosRepository.getById(tipo);
			Long produco = itemSaida.getProductos().getId();
			Productos prod = entradasRepository.getById(produco);
			
			String lote =itemSaida.getLote();
			//String prat = itemSaida.getPratileira();
			//String arm = itemSaida.getArmario();
			
			ItemEntradas item = itemEntradasRepository.buscar(lote, prod, tipos);
			
			item.setQuantidadeActual(item.getQuantidadeActual() - itemSaida.getQuanditade());
			itemSaida.setEntradas(item.getEntradas());
			
			
			
		}
		
		// MUDAR O  ESTADO DA SOLICITAÇÃO PARA FINALIZADO QUANDO TERMINAR A ACCÇÃO
		Long idSolicitacao = saidas.getSolicitacao().getId();
		Solicitacao solicitacao = solicitacaoRepository.getById(idSolicitacao);
		if(solicitacao.getId().equals(idSolicitacao)) {
			solicitacao.setEstado("Finalizada");
		}
		
		
		
		return  repository.save(saidas);
		
	}

	@Override
	public Saidas buscarOuFalhar(Long saidasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Saidas> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Saidas> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
