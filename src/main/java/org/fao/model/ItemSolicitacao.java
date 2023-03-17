package org.fao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITEM_SOLICITACAO")
public class ItemSolicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal gramas;
	private Long quantidade;
	private boolean visibidade;
	@ManyToOne
	@JoinColumn(name = "productos")
	private Productos productos;
	@ManyToOne
	@JoinColumn(name = "tipo")
	private TipoProductos tipo;
	@ManyToOne
	@JoinColumn(name = "solicitacao")
	private Solicitacao solicitacao;
	
	
}
