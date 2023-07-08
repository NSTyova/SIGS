package org.fao.resources;

public class UserAzureAD {

	 private String email;
	    private String nome;
	    // Outros atributos que você desejar receber

	    public UserAzureAD() {
	    }

	    public UserAzureAD(String email, String nome) {
	        this.email = email;
	        this.nome = nome;
	    }

	    // Getters e Setters
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }
}
