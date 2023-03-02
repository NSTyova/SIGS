package org.fao.service.impl.dashProjections;

import java.util.List;

import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.projections.ProductoEntregeCancelados;
import org.fao.projections.ProductosCategorias;
import org.fao.projections.ProductosQTDSaidaDia;
import org.fao.repository.ItemComprovanteRepository;
import org.fao.repository.ProductosRepository;
import org.fao.service.dash.DashGraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashGraficoImpl implements DashGraficaService {

	@Autowired
	private ItemComprovanteRepository itens;

	@Autowired
	private ProductosRepository productos;

	@Override
	public List<ProductoEntregeCancelados> productos(String utilizador) {
		return itens.productos(utilizador);
	}

	@Override
	public List<ProductosCategorias> qtdProductos() {
		return productos.qtdProductos();
	}

	@Override
	public List<ProductosQTDSaidaDia> limitados(String utlizador) {
		return itens.limitados( utlizador);
	}

	@Override
	public CardsSaidaEntradaPaciente card(String utilizador) {
		 return itens.cards(utilizador);
	}

	/*@Override
	public List<QTDMedPaciente> qtdMedPaciente() {
		return itens.qtdMedPaciente();
	}
*/
}
