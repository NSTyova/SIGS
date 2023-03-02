package org.fao.security;

import java.util.Date;

import org.fao.model.Utilizador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	// injectar uma propriedade
		@Value("${forum.jwt.expiration}")
		private String expiration;
		
		@Value("${forum.jwt.secret}")
		private String secret;
	
		static final String HEADER_STRING = "Authorization";

		public String gerarToken(Authentication authenticate) {
			// TODO Auto-generated method stub
			Utilizador logado  = (Utilizador) authenticate.getPrincipal();
			Date hoje = new Date();
			Date dateExpiration = new Date(hoje.getTime() + Long.parseLong(expiration));
			
			return Jwts.builder()
					.setIssuer("Plataforma ECA")
					//.setSubject(logado.getPerfis().toString())
					.setSubject(logado.getId().toString())
					//.setAudience(logado.getNome())
					.setAudience(logado.getPermissoes().toString())
					.setIssuedAt(hoje)
					.setExpiration(dateExpiration)
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
			// pegar o objecto do token aqui
		}

		public boolean isTokenValido(String token) {
			try {
				Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
				return true;
			} catch (Exception e) {
				return false;
			}
			
			
		}

		public Long getIdUsuario(String token) {
			Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
			return Long.parseLong(claims.getSubject());
		}

 
}
