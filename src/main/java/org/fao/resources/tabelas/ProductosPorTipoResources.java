package org.fao.resources.tabelas;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.service.dtoExcel.EntradasExcel;
import org.fao.service.dtoExcel.SaidasExcel;
import org.fao.service.projections.EntradasSaidasProjections;
import org.fao.service.projections.InventarioEntradasProjections;
import org.fao.service.projections.InventarioSaidasProjections;
import org.fao.service.projections.ProductosPorTipoProjections;
import org.fao.service.projections.QuantidadesPorLotesProjections;
import org.fao.service.projections.QuantidadesPorTiposProjections;
import org.fao.service.projections.SolicitacaoPorServicosProjections;
import org.fao.service.tabelas.TabelasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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
	private TabelasServices services;

	@GetMapping
	public List<ProductosPorTipoProjections> tipos(@RequestParam Long deposito) {

		return services.totalProductosTipos(deposito);
	}

	@GetMapping(value = "qtdLotes")
	public List<QuantidadesPorLotesProjections> quantidades() {

		return services.quantidadePorLotes();
	}

	@GetMapping(value = "qtdTipos")
	public List<QuantidadesPorTiposProjections> quantidadesTipos(@RequestParam Long deposito) {

		return services.quantidadePorTipo(deposito);
	}

	@GetMapping(value = "qtdService")
	public List<SolicitacaoPorServicosProjections> quantidadesService() {

		return services.solicitacaoServico();
	}

	@GetMapping(value = "entradasSaidas")
	public EntradasSaidasProjections entradasSaidas(@RequestParam Long deposito) {

		return services.entradasSaidas(deposito);
	}

	@GetMapping(value = "entradas")
	public Page<InventarioEntradasProjections> entradas(@RequestParam int pagina, @RequestParam int qtd,
			@RequestParam Long deposito,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
		return services.entradas(paginacao, deposito, dataInicio, dataFim);
	}

	@GetMapping(value = "saidas")
	public Page<InventarioSaidasProjections> saidas(@RequestParam int pagina, @RequestParam int qtd,
			@RequestParam Long deposito,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		return services.saidas(paginacao, deposito, dataInicio, dataFim);
	}

	// Exportar em Excel Xlsx usando o back
	@GetMapping("/export/excel")
	public void exportToXLS(HttpServletResponse response, @RequestParam Long deposito,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=InventarioDeEntradas.xlsx";

		response.setHeader(headerKey, headerValue);

		List<ItemEntradas> listaEcas = services.listaExcel(deposito, dataInicio, dataFim);

		/**
		 * desenho do Exel
		 */
		EntradasExcel entradas = new EntradasExcel(listaEcas);
		entradas.export(response);

	}

	// EXPORTAR EXCEL PARA SAIDAS 
	@GetMapping("/export/saidas")
	public void exportToXLSSaidas(HttpServletResponse response, @RequestParam Long deposito,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=InventarioDeSaidas.xlsx";

		response.setHeader(headerKey, headerValue);

		List<ItemSaida> listaSaidas = services.listaExcelSaidas(deposito, dataInicio, dataFim);

		/**
		 * desenho do Exel
		 */
		SaidasExcel saidas = new SaidasExcel(listaSaidas);
		saidas.export(response);

	}

}
