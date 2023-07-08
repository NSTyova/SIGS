package org.fao.resources;

import java.io.IOException;

import javax.persistence.Cacheable;
import javax.servlet.http.HttpServletResponse;

import org.fao.model.Entradas;
import org.fao.model.Utilizador;
import org.fao.resources.DTO.EntradasDTO;
import org.fao.resources.relatorios.JasperService;
import org.fao.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/entradas")
@CrossOrigin("*")
public class EntradasController {

	@Autowired
	private EntradaService service;
	
	@Autowired
	private JasperService serviceJ;
	
	
	@GetMapping
	//@Cacheable(value="listaEntradas") // CACHE DOS DADOS 
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Page<EntradasDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Entradas> entradas = service.listar(paginacao);
			return EntradasDTO.convert(entradas);
		} else {
			Page<Entradas> entradas = service.buscarPorNome(paginacao, nome);
			return EntradasDTO.convert(entradas);
		}
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//@Cacheable(value="listaEntradas") // CACHE DOS DADOS
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public void adicionar(@RequestBody Entradas entradas, HttpServletResponse response,  Authentication user
				) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		//entradas.setUtilizador(user.getName());
		entradas.setEmailUtilizador(user.getName());
		//SALVAR O OBEJCTO
		service.gravar(entradas);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		//serviceJ.addParams("idEntradas", entradas.getId());
		//byte[] bytes = serviceJ.exportPDSubF();
		//response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		//response.getOutputStream().write(bytes);

	}
	
	@PostMapping(value = "transferencia")
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value="listaEntradas" , allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public void adicionarT(@RequestBody Entradas entradas, HttpServletResponse response,  Utilizador
				utilizador) throws JRException, IOException {
		//PEGAR O UTILIZADOR LOGADO
		entradas.setUtilizador(utilizador);
		//SALVAR O OBEJCTO
		service.gravarT(entradas);
		// ACAO QUE RETORNO O PDF QUANDO FEITO A INVERSAO DE UM VALORES NO BANCO DE DADOS
		serviceJ.addParams("idEntradas", entradas.getId());
		//byte[] bytes = serviceJ.exportPDSubF();
		//response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		
		//response.getOutputStream().write(bytes);

	}
	
	@GetMapping("/{entradasId}")
	@CacheEvict(value="listaEntradas" , allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Entradas buscar(@PathVariable Long entradasId) {
		return service.buscarOuFalhar(entradasId);
	}


}
