package org.fao.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.Estoque;
import org.fao.model.Utilizador;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.ProductosNaoEncontradoException;
import org.fao.resources.DTO.EstoqueDTO;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.EstoqueService;
import org.fao.service.form.CancelarSolicitacao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("*")
public class EstoqueController {

	/*@Autowired
	private EstoqueService service;
	
	@Autowired
	private JasperService serviceJ;
	


	@GetMapping
	public Page<EstoqueDTO> listar( @RequestParam int pagina, @RequestParam int qtd, @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Estoque> estoque = service.listarVendidas(paginacao,utilizador );
			return EstoqueDTO.convert(estoque);
	}
	@GetMapping(value = "/cancelados")
	public Page<EstoqueDTO> listarCanceladas( @RequestParam int pagina, @RequestParam int qtd,  @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Estoque> estoque = service.listarCanceladas(paginacao, utilizador);
			return EstoqueDTO.convert(estoque);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Estoque estoque, HttpServletResponse response, @AuthenticationPrincipal Utilizador
				utilizador) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		estoque.setUtilizador(utilizador);
		//SALVAR O OBEJCTO
		service.gravar(estoque);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		serviceJ.addParams("idEstoque", estoque.getId());
		byte[] bytes = serviceJ.exportPDSubF();
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		response.getOutputStream().write(bytes);

	}

	// FAZER UM METODO QUE BUSCAR AS FACTURAS COM BASE NO CODIGO DAS VENDA
	@PutMapping("/cancelar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Estoque alterarQTD(@PathVariable Long id, @RequestBody CancelarEstoque estoque) {
		try {

			Estoque estoqueActual = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(estoque, estoqueActual);
			return service.cancel(estoqueActual);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}

	}
*/
}
