package org.fao.resources.form;

public class EditarSenha {

	private Long id;
	private String senha;
	public EditarSenha(Long id, String senha) {
		super();
		this.id = id;
		this.senha = senha;
	}
	public EditarSenha() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
