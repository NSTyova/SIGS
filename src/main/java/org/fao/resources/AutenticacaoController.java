package org.fao.resources;
import javax.validation.Valid;

import org.fao.model.Utilizador;
import org.fao.resources.DTO.TokenDTO;
import org.fao.resources.form.LoginForm;
import org.fao.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form, @AuthenticationPrincipal Utilizador logado){
		// VER AQUI UMA LOGICA QUE QUANDO DAS DATAS FOREM DIFERENTE NAO LOGA BUSCAR SOMENTE DADOS DAS UNIDADES TRUE
		UsernamePasswordAuthenticationToken dadosLogin=form.converter();
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token= tokenService.gerarToken(authenticate);
			//System.out.println(token);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer "));
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
