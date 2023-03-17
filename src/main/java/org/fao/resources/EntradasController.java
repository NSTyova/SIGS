package org.fao.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.Entradas;
import org.fao.model.Utilizador;
import org.fao.resources.DTO.EntradasDTO;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.sf.jasperreports.engine.JRException;

public class EntradasController {

	@Autowired
	private EntradaService service;
	
	@Autowired
	private JasperService serviceJ;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Entradas entradas, HttpServletResponse response, @AuthenticationPrincipal Utilizador
				utilizador) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		entradas.setUtilizador(utilizador);
		//SALVAR O OBEJCTO
		service.gravar(entradas);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		serviceJ.addParams("idEntradas", entradas.getId());
		byte[] bytes = serviceJ.exportPDSubF();
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		response.getOutputStream().write(bytes);

	}


}
