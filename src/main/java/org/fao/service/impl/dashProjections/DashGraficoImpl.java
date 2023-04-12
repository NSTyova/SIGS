package org.fao.service.impl.dashProjections;

import java.util.List;

import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.repository.ItemSaidasRepository;
import org.fao.repository.ItemSolicitacaoRepository;
import org.fao.repository.SolicitacaoRepository;
import org.fao.service.dash.DashGraficaService;
import org.fao.service.projections.ProductoMaisSolicitados;
import org.fao.service.projections.SolicitacoaQDT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashGraficoImpl implements DashGraficaService {

	@Autowired
	private ItemSaidasRepository itens;

	@Autowired
	private SolicitacaoRepository solicitacao;
	
	@Autowired
	private ItemSolicitacaoRepository item;

	@Override
	public CardsSaidaEntradaPaciente card(String utilizador) {
		 return itens.cards(utilizador);
	}



	@Override
	public List<SolicitacoaQDT> limitados(String utlizador) {
		// TODO Auto-generated method stub
		return solicitacao.limitados(utlizador);
	}



	@Override
	public List<ProductoMaisSolicitados> productosMSolicitados(String utlizador) {
		// TODO Auto-generated method stub
		return item.productosMSolicitados(utlizador);
	}

	/*@Override
	public List<QTDMedPaciente> qtdMedPaciente() {
		return itens.qtdMedPaciente();
	}
*/
}
