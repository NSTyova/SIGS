package org.fao.resources.tabelas;

import java.util.List;

import org.fao.service.projections.EntradasSaidasProjections;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.fao.service.tabelas.TabelasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tabelas")
@CrossOrigin("*")
public class ProductosPorTipoResources {

	@Autowired
	private  TabelasServices services;
	
	@GetMapping
	public List<ProductosPorTipoProjections> tipos(@RequestParam Long deposito){

		return services.totalProductosTipos(deposito);
	}
	
	@GetMapping(value = "qtdLotes")
	public List<QuantidadesPorLotesProjections> quantidades(){

		return services.quantidadePorLotes();
	}
	
	@GetMapping(value = "qtdTipos")
	public List<QuantidadesPorTiposProjections> quantidadesTipos(@RequestParam Long deposito){

		return services.quantidadePorTipo(deposito);
	}
	
	@GetMapping(value = "qtdService")
	public List<SolicitacaoPorServicosProjections> quantidadesService(){

		return services.solicitacaoServico();
	}
	
	@GetMapping(value = "entradasSaidas")
	public EntradasSaidasProjections entradasSaidas(@RequestParam Long deposito){

		return services.entradasSaidas(deposito);
	}
}