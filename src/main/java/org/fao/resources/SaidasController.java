package org.fao.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.Saidas;
import org.fao.model.Utilizador;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.SaidasService;
import org.fao.service.form.CancelarSaidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.sf.jasperreports.engine.JRException;

public class SaidasController {

	@Autowired
	private SaidasService service;
	
	@Autowired
	private JasperService serviceJ;
	
	/*@GetMapping
	public Page<SaidasDTO> listar( @RequestParam int pagina, @RequestParam int qtd, @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Saidas> saidas = service.listarVendidas(paginacao,utilizador );
			return SaidasDTO.convert(saidas);
	}
	@GetMapping(value = "/cancelados")
	public Page<SaidasDTO> listarCanceladas( @RequestParam int pagina, @RequestParam int qtd,  @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Saidas> saidas = service.listarCanceladas(paginacao, utilizador);
			return SaidasDTO.convert(saidas);
	}*/

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Saidas saidas, HttpServletResponse response, @AuthenticationPrincipal Utilizador
				utilizador) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		saidas.setUtlizador(utilizador);
		//SALVAR O OBEJCTO
		service.gravar(saidas);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		serviceJ.addParams("idSaidas", saidas.getId());
		byte[] bytes = serviceJ.exportPDSubF();
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		response.getOutputStream().write(bytes);

	}

	// CANCELAR UMA SOLICITACAO E SO MUDAR O ESTADO
	@PutMapping("/cancelar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Saidas alterarQTD(@PathVariable Long id, @RequestBody CancelarSaidas saidas) {
		return null;
		/*try {

			Saidas saidasActual = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(saidas, saidasActual);
			return service.cancel(saidasActual);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}*/

	}

}
