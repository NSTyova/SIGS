package org.fao.resources.dahsGrafico;

import java.util.List;

import org.fao.model.Utilizador;
import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.projections.ProductoEntregeCancelados;
import org.fao.projections.ProductosCategorias;
import org.fao.projections.ProductosQTDSaidaDia;
import org.fao.service.dash.DashGraficaService;
import org.fao.service.projections.ProductoMaisSolicitados;
import org.fao.service.projections.SolicitacoaQDT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashGrafico")
@CrossOrigin("*")
public class GraficoDashController {

	@Autowired
	private DashGraficaService dashGraficaService;
	
	/*@GetMapping
	public List<ProductoEntregeCancelados> productos(@AuthenticationPrincipal Utilizador logado){
		String utilizador = logado.getNomeLogin();
		// falta quantidade entregues e cancelados 
		return dashGraficaService.productos(utilizador);
	}
	
	*/
	
	
	@GetMapping
	public  List<SolicitacoaQDT> limitados(@AuthenticationPrincipal Utilizador logado){
		// trazer
		String utilizador = logado.getEmail();
		return dashGraficaService.limitados(utilizador);
	}
	
	@GetMapping(value="/solicitacao")
	public  List<ProductoMaisSolicitados> productosMSolicitados(@AuthenticationPrincipal Utilizador logado){
		String utilizador = logado.getEmail();
		return dashGraficaService.productosMSolicitados(utilizador);
	}
	
	@GetMapping(value = "cards")
	public CardsSaidaEntradaPaciente cards(@AuthenticationPrincipal Utilizador logado){
		String utilizador = logado.getEmail();
		 return dashGraficaService.card(utilizador);
	}
	
	/*@GetMapping(value = "qtdMedPaciente")
	public List<QTDMedPaciente> qtdMedPaciente() {
		return dashGraficaService.qtdMedPaciente();
	}*/
}
