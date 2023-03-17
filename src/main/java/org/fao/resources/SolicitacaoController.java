package org.fao.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.SolicitacaoService;
import org.fao.service.form.CancelarSolicitacao;
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


public class SolicitacaoController {

	@Autowired
	private SolicitacaoService service;
	
	@Autowired
	private JasperService serviceJ;
	
	/*@GetMapping
	public Page<SolicitacaoDTO> listar( @RequestParam int pagina, @RequestParam int qtd, @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Solicitacao> solicitacao = service.listarVendidas(paginacao,utilizador );
			return SolicitacaoDTO.convert(solicitacao);
	}
	@GetMapping(value = "/cancelados")
	public Page<SolicitacaoDTO> listarCanceladas( @RequestParam int pagina, @RequestParam int qtd,  @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Solicitacao> solicitacao = service.listarCanceladas(paginacao, utilizador);
			return SolicitacaoDTO.convert(solicitacao);
	}*/

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Solicitacao solicitacao, HttpServletResponse response, @AuthenticationPrincipal Utilizador
				utilizador) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		solicitacao.setUtilizador(utilizador);
		//SALVAR O OBEJCTO
		service.gravar(solicitacao);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		serviceJ.addParams("idSolicitacao", solicitacao.getId());
		byte[] bytes = serviceJ.exportPDSubF();
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		response.getOutputStream().write(bytes);

	}

	// CANCELAR UMA SOLICITACAO E SO MUDAR O ESTADO
	@PutMapping("/cancelar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Solicitacao alterarQTD(@PathVariable Long id, @RequestBody CancelarSolicitacao solicitacao) {
		return null;
		/*try {

			Solicitacao solicitacaoActual = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(solicitacao, solicitacaoActual);
			return service.cancel(solicitacaoActual);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}*/

	}

}
