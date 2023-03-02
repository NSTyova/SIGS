package org.fao.resources.relatorios;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

	@Autowired
	private JasperService service;
	// para o outro relatorio com subRelatorio mas com parametros
	@GetMapping(value = "/pesquisar")
	public void exibirRelatio(@RequestParam Long idEstoque,HttpServletResponse response) throws JRException, IOException {
		
		service.addParams("idEstoque", idEstoque);
		byte[] bytes = service.exportPDSubF();
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		response.getOutputStream().write(bytes);
	}
	// fim	
}
