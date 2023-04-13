package org.fao.resources;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.ItemSaida;
import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.UtilizadorNaoEncontradoException;
import org.fao.resources.DTO.ItemSolicitacaoDTO;
import org.fao.resources.DTO.SolicitacaoDTO;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.SolicitacaoService;
import org.fao.service.dtoExcel.SaidasExcel;
import org.fao.service.form.CancelarSolicitacao;
import org.fao.service.form.EditarSolicitacao;
import org.fao.service.form.RemoverProducto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@RequestMapping("/solicitacao")
@CrossOrigin("*")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoService service;
	
	@Autowired
	private JasperService serviceJ;
	
	@GetMapping
	public Page<SolicitacaoDTO> listar( @RequestParam int pagina, @RequestParam int qtd, @AuthenticationPrincipal Utilizador logado) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Solicitacao> solicitacao = service.listar(paginacao);
			return SolicitacaoDTO.convert(solicitacao);
		
		
	}
	
	@GetMapping(value = "/aprovados")
	public Page<SolicitacaoDTO> listarAprovados( @RequestParam int pagina, @RequestParam int qtd, @AuthenticationPrincipal Utilizador logado) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Solicitacao> solicitacao = service.listarAprovados(paginacao);
			return SolicitacaoDTO.convert(solicitacao);
		
		
	}
	
	/*
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
		solicitacao.setSolicitante(utilizador);
		//SALVAR O OBEJCTO
		service.gravar(solicitacao);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		//serviceJ.addParams("idSolicitacao", solicitacao.getId());
		//byte[] bytes = serviceJ.exportPDSubF();
		//response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		//response.getOutputStream().write(bytes);

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

	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	//@PreAuthorize("hasAnyAuthority('Editar_Usuarios')")
	public Solicitacao atualizar(@PathVariable Long id, @RequestBody EditarSolicitacao editar,
			@AuthenticationPrincipal Utilizador utilizador) {
		try {
			editar.setAprovou(utilizador);
			Solicitacao solicitacao = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(editar, solicitacao);
			return service.editar(id, editar);
		} catch (UtilizadorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	
	
	@GetMapping("/{solicitacaoId}")
	public List<ItemSolicitacao> buscar(@PathVariable List<Solicitacao> solicitacaoId) {
		return service.buscarPorId(solicitacaoId);
	}
	
	@GetMapping(value="solicitacao/{solicitacaoId}")
	public List<ItemSolicitacao> buscarIdAprovados(@PathVariable List<Solicitacao> solicitacaoId) {
		return service.buscarPorAprovados(solicitacaoId);
	}
	
	
	// BUSCAR ESTADO EM INTERVALO DE DATAS
	@GetMapping("/estado")
	public Page<Solicitacao> buscarPorEstadosDatas(
			@RequestParam int pagina, @RequestParam int qtd,
			@RequestParam String estado,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
		return	service.buscarPorEstadosDatas(paginacao ,estado, dataInicio, dataFim);
	}
}
