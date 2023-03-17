package org.fao.resources.dahsGrafico;

import java.util.List;

import org.fao.model.Utilizador;
import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.projections.ProductoEntregeCancelados;
import org.fao.projections.ProductosCategorias;
import org.fao.projections.ProductosQTDSaidaDia;
import org.fao.service.dash.DashGraficaService;
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

	/*@Autowired
	private DashGraficaService dashGraficaService;
	
	@GetMapping
	public List<ProductoEntregeCancelados> productos(@AuthenticationPrincipal Utilizador logado){
		String utilizador = logado.getNomeLogin();
		// falta quantidade entregues e cancelados 
		return dashGraficaService.productos(utilizador);
	}
	
	
	@GetMapping(value = "qtdCategorias")
	public List<ProductosCategorias> produsctoCategoruas(){
		return dashGraficaService.qtdProductos();
	}
	
	@GetMapping(value = "saidasProductos")
	public List<ProductosQTDSaidaDia> productosSaidos(@AuthenticationPrincipal Utilizador logado){
		// trazer
		String utilizador = logado.getNomeLogin();
		System.out.println("Utilizador Logado :"+ logado.getNomeLogin());
		return dashGraficaService.limitados(utilizador);
	}
	
	@GetMapping(value = "cards")
	public CardsSaidaEntradaPaciente cards(@AuthenticationPrincipal Utilizador logado){
		String utilizador = logado.getNomeLogin();
		System.out.println("Utilizador Logado :"+ logado.getNomeLogin());
		 return dashGraficaService.card(utilizador);
	}
	
	/*@GetMapping(value = "qtdMedPaciente")
	public List<QTDMedPaciente> qtdMedPaciente() {
		return dashGraficaService.qtdMedPaciente();
	}*/
}
