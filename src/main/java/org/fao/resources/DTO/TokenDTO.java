package org.fao.resources.DTO;

public class TokenDTO {

	private String token;
	private String tipo;
	
	public TokenDTO(String token, String tipo) {
		// TODO Auto-generated constructor stub
		this.token=token;
		this.tipo=tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
