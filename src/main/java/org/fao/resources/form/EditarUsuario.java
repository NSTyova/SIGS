package org.fao.resources.form;

import org.fao.model.Utilizador;

public class EditarUsuario {

	private Long id;
	private String name;
	private String nomeLogin;
	//private List<Per> perfis;
	
	
	
	public EditarUsuario() {
		super();
	}

	
	public EditarUsuario (Utilizador usuario) {
		this.id=usuario.getId();
		this.name=usuario.getName();
		this.nomeLogin=usuario.getNomeLogin();
		//this.perfis=usuario.getPerfis();
	}


	public EditarUsuario(Long id, String name, String nomeLogin /*List<Perfil> perfis*/) {
		super();
		this.id = id;
		this.name = name;
		this.nomeLogin = nomeLogin;
		//this.perfis = perfis;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNomeLogin() {
		return nomeLogin;
	}


	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}
	

}
