package org.fao.service.dash;

import java.util.List;

import org.fao.model.Utilizador;
import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.service.projections.ProductoMaisSolicitados;
import org.fao.service.projections.SolicitacoaQDT;
import org.springframework.stereotype.Service;

@Service
public interface DashGraficaService {
/*
	// PRODUCTOS ENTRADOS E CANCELADOS
	public List<ProductoEntregeCancelados> productos(String utilizador);
	
	
	// QTD DE PRODCUTOS POR CATEGORIAS
	public List<ProductosCategorias> qtdProductos();
	
	// PRODUCTOS MAIS SAIDOS POR DIA LIMITADO EM 10 LINHAS
	List<ProductosQTDSaidaDia> limitados(String utlizador);
	
*/
	
	//CARDS SAIDAS, ENTREGUE, PACIENTES QUANTIDADE
	CardsSaidaEntradaPaciente card(String utilizador);
	
	List<SolicitacoaQDT> limitados(String utlizador);
	
	List<ProductoMaisSolicitados> productosMSolicitados(String logado);
	
}
