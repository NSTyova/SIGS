package org.fao.resources;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.fao.model.ItemSolicitacao;
import org.fao.model.ItemTransferencia;
import org.fao.model.Solicitacao;
import org.fao.model.Transferencia;
import org.fao.model.Utilizador;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.UtilizadorNaoEncontradoException;
import org.fao.resources.DTO.TransferenciaDTO;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.TransferenciaService;
import org.fao.service.form.CancelarSolicitacao;
import org.fao.service.form.EditarSolicitacao;
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
@RequestMapping("/transferencia")
@CrossOrigin("*")
public class TransferenciaController {

	
	@Autowired
	private TransferenciaService service;
	
	@Autowired
	private JasperService serviceJ;
	
	@GetMapping
	public Page<TransferenciaDTO> listar( @RequestParam int pagina, @RequestParam int qtd, @AuthenticationPrincipal Utilizador logado) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

			Page<Transferencia> transferencia = service.listar(paginacao);
			return TransferenciaDTO.convert(transferencia);
		
		
	}
	/*
	@GetMapping(value = "/cancelados")
	public Page<SolicitacaoDTO> listarCanceladas( @RequestParam int pagina, @RequestParam int qtd,  @AuthenticationPrincipal Utilizador logado) {
			String utilizador = logado.getNomeLogin();
			Pageable paginacao = PageRequest.of(pagina, qtd);
			Page<Transferencia> transferencia = service.listarCanceladas(paginacao, utilizador);
			return SolicitacaoDTO.convert(transferencia);
	}*/

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Transferencia transferencia, HttpServletResponse response, @AuthenticationPrincipal Utilizador
				utilizador) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		transferencia.setUtilizador(utilizador);
		//SALVAR O OBEJCTO
		service.gravar(transferencia);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		//serviceJ.addParams("idSolicitacao", transferencia.getId());
		//byte[] bytes = serviceJ.exportPDSubF();
		//response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		//response.getOutputStream().write(bytes);

	}
	
	@GetMapping("/findBy/{id}")
	public Transferencia buscarPorId(@PathVariable Long id) {
		return service.buscarOuFalhar(id);
	}
	
	@GetMapping("/{tId}")
	public List<ItemTransferencia> buscar(@PathVariable List<Transferencia> tId) {
		return service.buscarPorId(tId);
	}

	// CANCELAR UMA SOLICITACAO E SO MUDAR O ESTADO
	@PutMapping("/cancelar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Transferencia alterarQTD(@PathVariable Long id, @RequestBody CancelarSolicitacao transferencia) {
		return null;
		/*try {

			Transferencia solicitacaoActual = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(transferencia, solicitacaoActual);
			return service.cancel(solicitacaoActual);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}*/

	}

	
	// BUSCAR ESTADO EM INTERVALO DE DATAS
	@GetMapping("/porDatas")
	public List<Transferencia> buscarPorEstadosDatas(
				@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
				@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
			return	service.buscarPorEstadosDatas( dataInicio, dataFim);
	}
	
	/*
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	//@PreAuthorize("hasAnyAuthority('Editar_Usuarios')")
	public Transferencia atualizar(@PathVariable Long id, @RequestBody EditarSolicitacao editar,
			@AuthenticationPrincipal Utilizador utilizador) {
		try {
			editar.setAprovou(utilizador);
			Transferencia transferencia = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(editar, transferencia);
			return service.editar(id, editar);
		} catch (UtilizadorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	
	
	@GetMapping("/{solicitacaoId}")
	public List<ItemSolicitacao> buscar(@PathVariable List<Transferencia> solicitacaoId) {
		return service.buscarPorId(solicitacaoId);
	}*/
}
