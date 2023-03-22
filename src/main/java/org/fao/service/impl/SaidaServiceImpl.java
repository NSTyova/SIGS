package org.fao.service.impl;

import java.util.List;

import org.fao.model.Entradas;
import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.model.Saidas;
import org.fao.repository.EntradasRepository;
import org.fao.repository.SaidasRepository;
import org.fao.service.SaidasService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaidaServiceImpl implements SaidasService{
	
	@Autowired
	private SaidasRepository repository;
	
	@Autowired
	private EntradasRepository entradaRepository;

	@Override
	public Saidas gravar(Saidas saidas) {
		
		// GRAVAR O ID QUE VEM NA SAIDA E GRAVAR NO ITEM-SAIDAS
		List<ItemSaida> iten = saidas.getIten();
		iten.forEach(s -> s.setSaidas(saidas));
		
		// PEGAR O ID DA LISTAR E  PASSAR A ENTRADA  
		Long id = saidas.getEntradas().getId();
		Entradas entradas = entradaRepository.getById(id);
		
		// DIMINUIR A QUANTIDADE NO ITEM ENTRADA ESPECIFICO
		for (ItemEntradas ie: entradas.getIten()) {
			System.out.println("Chegou aqui "+ ie.getArmario());
			for(ItemSaida is : saidas.getIten()) {
				System.out.println("Quantidade da lista aqui "+ is.getQuanditade());
			}
			
		 /*for (Productos pd : co.getProductos()) {
		   Long id = pd.getId();
		   Productos productos =repository2.getById(id);
				productos.setQuantidade(productos.getQuantidade() - pd.getQuantidade());
		 }*/
		}
		return null;//repository.save(saidas);
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
