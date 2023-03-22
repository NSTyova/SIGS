package org.fao.resources;

import java.math.BigDecimal;
import java.util.List;

import org.fao.service.SolicitacaoProjectionService;
import org.fao.service.projections.SolicitadaoSaidaProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projections")
@CrossOrigin("*")
public class SolicitacaoProjectionController {

	
	@Autowired
	private SolicitacaoProjectionService service;
	
	@GetMapping
	public List<SolicitadaoSaidaProjections> pesquisa(@RequestParam Long producto, @RequestParam Long tipo,
													  @RequestParam Long deposito,@RequestParam BigDecimal gramas) {
		return service.buscar(producto, tipo, deposito, gramas);
		

	}
	
	
}
