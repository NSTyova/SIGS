package org.fao.service.form;

import org.fao.model.ItemSolicitacao;
import org.fao.model.Solicitacao;
import org.fao.model.Utilizador;

public class RemoverProducto {

	private Long id;
	private boolean visibilidade = false;
	private Utilizador utilizador;
	
	
	public RemoverProducto() {
		super();
	}
	public RemoverProducto(ItemSolicitacao item) {
		this.id=item.getId();
		this.visibilidade=item.isVisibidade();
		this.utilizador=item.getSolicitacao().getAprovou();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	
}
