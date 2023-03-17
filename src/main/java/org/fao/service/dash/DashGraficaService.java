package org.fao.service.dash;

import java.util.List;

import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.projections.ProductoEntregeCancelados;
import org.fao.projections.ProductosCategorias;
import org.fao.projections.ProductosQTDSaidaDia;
import org.springframework.stereotype.Service;

@Service
public interface DashGraficaService {

	/*// PRODUCTOS ENTRADOS E CANCELADOS
	public List<ProductoEntregeCancelados> productos(String utilizador);
	
	
	// QTD DE PRODCUTOS POR CATEGORIAS
	public List<ProductosCategorias> qtdProductos();
	
	// PRODUCTOS MAIS SAIDOS POR DIA LIMITADO EM 10 LINHAS
	List<ProductosQTDSaidaDia> limitados(String utlizador);
	
	// QUANTIDADE MEDICAMENTO LEVADOS POR PACIENTES DIARIAMENTE
	List<QTDMedPaciente> qtdMedPaciente()
	
	//CARDS SAIDAS, ENTREGUE, PACIENTES QUANTIDADE
	CardsSaidaEntradaPaciente card(String utilizador);*/
	
}
