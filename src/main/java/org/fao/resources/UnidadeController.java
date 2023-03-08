package org.fao.resources;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.fao.model.Unidade;
import org.fao.model.Utilizador;
import org.fao.model.exception.CategoriasNaoEncontradoException;
import org.fao.model.exception.NegocioException;
import org.fao.service.UnidadeService;
import org.fao.service.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/unidades")
@CrossOrigin("*")
public class UnidadeController {

	@Autowired
	private UnidadeService service;
	
	@Autowired
	private UtilizadorService utilizadorService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Unidade adicionar(@RequestBody @Valid Unidade unidade) {
		try {
			return service.gravar(unidade);
		} catch (CategoriasNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	/*
	private Unidade unidade;
	
	public void licenta() throws Throwable {
	 unidade.getCodigo();= LocalDate.now();
     LocalDate dataExpiracao = dataAtual.plusYears(1);

     List<Utilizador> utilizadores = utilizadorService.lista();

     while (true) {
         if (dataAtual.isBefore(dataExpiracao)) {
             // Licença ainda é válida, mantém os funcionários ativos
             for (Utilizador u : utilizadores) {
            	 u.setEstado(false);
             }
         } else {
             // Licença expirou, muda o estado de todos os funcionários para false
             for (Utilizador u : utilizadores) {
            	 u.setEstado(false);
             }
         }

         // Espera um tempo antes de verificar novamente
         Thread.sleep(1000);
     }
	}*/
}
