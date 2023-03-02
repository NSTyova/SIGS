package org.fao.resources.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	private String nomeLogin;
	private String senha;
	
	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		// TODO Auto-generated method stub
		return new UsernamePasswordAuthenticationToken(nomeLogin, senha);
	}
	
	
	
}
