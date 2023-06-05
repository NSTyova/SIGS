package org.fao.resources;

import javax.validation.Valid;

import org.fao.model.Utilizador;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.UtilizadorNaoEncontradoException;
import org.fao.resources.DTO.UtilizadorDTO;
import org.fao.resources.form.EditarSenha;
import org.fao.resources.form.EditarUsuario;
import org.fao.service.UtilizadorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/utilizador")
@CrossOrigin("*")
public class UtilizadorController {

	@Autowired
	private UtilizadorService service;
/*
	@GetMapping
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Page<UtilizadorDTO> listar(@RequestParam(required = false) String nome, @RequestParam int pagina,
			@RequestParam int qtd) {
		try {
			
		
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (nome == null) {
			Page<Utilizador> utilizador = service.listar(paginacao);
			return UtilizadorDTO.convert(utilizador);
		} else {
			Page<Utilizador> utilizador = service.buscarPorNome(paginacao, nome);
			return UtilizadorDTO.convert(utilizador);
		}
	}catch (AccessDeniedException e) {
        throw new AccessDeniedException("Acesso negado: você não possui as permissões necessárias.", e);
    }
	}*/

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Utilizador adicionar(@RequestBody @Valid Utilizador utilizador) {
		try {
			return service.gravar(utilizador);
		} catch (UtilizadorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	//@PreAuthorize("hasAnyAuthority('Editar_Usuarios')")
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Utilizador atualizar(@PathVariable Long id, @RequestBody EditarUsuario editarUsuario) {
		try {
			Utilizador usuariooAtual = service.buscarOuFalhar(id);
			BeanUtils.copyProperties(editarUsuario, usuariooAtual);
			return service.editar(id, editarUsuario);
		} catch (UtilizadorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@GetMapping("/{utilizdorId}")
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Utilizador buscar(@PathVariable Long utilizdorId) {
		return service.buscarOuFalhar(utilizdorId);
	}
	
	//@PutMapping("/editar/{id}")
	//@ResponseStatus(HttpStatus.ACCEPTED)
	//@PreAuthorize("hasAnyAuthority('Editar_Senha_Usuarios')")
	//@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	/*public Utilizador editarSenha(@PathVariable Long id,
			@RequestBody EditarSenha usuario) {
		try {
			Utilizador usuarioAtual = service.buscarOuFalhar(id);
			String crypt = new BCryptPasswordEncoder().encode(usuario.getSenha());
			usuario.setSenha(crypt);
			BeanUtils.copyProperties(usuario, usuarioAtual);
			return service.gravar(usuarioAtual);
		} catch (UtilizadorNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}*/
}
