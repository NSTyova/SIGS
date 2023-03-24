package org.fao.service.impl;

import java.util.List;
import java.util.Optional;

import org.fao.model.Entradas;
import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.model.Productos;
import org.fao.model.Saidas;
import org.fao.model.TipoProductos;
import org.fao.repository.EntradasRepository;
import org.fao.repository.ItemEntradasRepository;
import org.fao.repository.ProductosRepository;
import org.fao.repository.SaidasRepository;
import org.fao.repository.SolicitacaoRepository;
import org.fao.repository.TipoProductosRepository;
import org.fao.service.SaidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaidaServiceImpl implements SaidasService {

	@Autowired
	private SaidasRepository repository;

	@Autowired
	private ItemEntradasRepository itemEntradasRepository;
	
	@Autowired
	private TipoProductosRepository tipoProductosRepository;
	
	@Autowired
	private  ProductosRepository entradasRepository;
	
	@Override
	public Saidas gravar(Saidas saidas) {

		// GRAVAR O ID QUE VEM NA SAIDA E GRAVAR NO ITEM-SAIDAS
		List<ItemSaida> iten = saidas.getIten();
		iten.forEach(s -> s.setSaidas(saidas));

		
		// PEGAR O ID DA LISTAR E PASSAR A ENTRADA
		//Long id = saidas.getEntradas().getId();
		//Entradas entradas = entradaRepository.getById(id); // pegar o repository da query tabem item entrada
		
		
		// PEGAR O PRODUCTO, TIPO, LOTE
		for(ItemSaida itemSaida : saidas.getIten()) {
			
			Long tipo = itemSaida.getTipo().getId();
			TipoProductos tipos = tipoProductosRepository.getById(tipo);
			Long produco = itemSaida.getProductos().getId();
			Productos prod = entradasRepository.getById(produco);
			String lote =itemSaida.getLote();
			ItemEntradas item = itemEntradasRepository.buscar(lote, prod, tipos);// item entradas
			item.setQuantidadeActual(item.getQuantidadeActual() - itemSaida.getQuanditade());
			itemSaida.setEntradas(item.getEntradas());
		}
		
		
		return  repository.save(saidas);
		
	}

	@Override
	public Saidas buscarOuFalhar(Long saidasId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Saidas> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Saidas> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
