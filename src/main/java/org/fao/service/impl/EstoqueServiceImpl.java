package org.fao.service.impl;

import java.util.List;

import org.fao.model.Comprovante;
import org.fao.model.Estado;
import org.fao.model.Estoque;
import org.fao.model.ItemComprovante;
import org.fao.model.Productos;
import org.fao.model.exception.EstoqueNaoEncontradoException;
import org.fao.repository.ComprovanteRepository;
import org.fao.repository.EstoqueRepository;
import org.fao.repository.ProductosRepository;
import org.fao.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServiceImpl implements EstoqueService {

	@Autowired
	private EstoqueRepository repository;

	@Autowired
	private ProductosRepository repository2;
	
	@Autowired
	private ComprovanteRepository comprovanteRepository;


	@Override
	public Estoque gravar(Estoque estoque) {

		// USANDO LAMBDA DO JAVA 8 QUANDO FOR UMA LINHA
		List<Comprovante> f =estoque.getComprovantes();
		f.forEach(cp -> cp.setEstoque(estoque));
		
		// CONDICAO QUE PEGA O ID A VENDA E PASSA O MESMO PARA O FACTURA
		for (Comprovante co : estoque.getComprovantes()) {
			for (Productos pd : co.getProductos()) {
				Long id = pd.getId();
				Productos productos =repository2.getById(id);
				productos.setQuantidade(productos.getQuantidade() - pd.getQuantidade());
				
				// USANDO UMA EXPRESSAO LAMBDA PARA ITERAR A LISTA
				List<ItemComprovante> itemCom = co.getItemComprovante();
				itemCom.forEach(it -> it.setComprovante(co));
					
				
				//for (ItemComprovante itemFactura : fa.getItemComprovante()) {
					//	itemFactura.setFactura(fa);
					//}
			
		}

		}
	

		return repository.save(estoque);
	}



	@Override
	public Estoque buscarOuFalhar(Long estoqueId) {
		return repository.findById(estoqueId).orElseThrow(() -> new EstoqueNaoEncontradoException(estoqueId));
	}

	@Override
	public Page<Estoque> listarVendidas(Pageable paginacao, String utilizador) {
		return repository.buscarPorStatusVendido(paginacao, utilizador);
	}
	
	@Override
	public Page<Estoque> listarCanceladas(Pageable paginacao, String utilizador) {
		return repository.buscarPorStatusCancelado(paginacao, utilizador);
	}

	@Override
	public Estoque cancel(Estoque estoque) {
		Long id =estoque.getId();
		Comprovante fa =comprovanteRepository.getByEstoqueId(id);
		for(Productos pd : fa.getProductos()) {
			Long idProducto = pd.getId();
			Productos productos = repository2.getById(idProducto);
				for(ItemComprovante itc : fa.getItemComprovante()) {
					// MUDAR O STATUS SE JA FOR CANCELADO NAO CANCELAR MAIS
					if(itc.getProductos().getId().equals(productos.getId())) {
						productos.setQuantidade(productos.getQuantidade() + itc.getQuantidade());	
					}else {
						System.out.println("NAO FAZ NADA");
					}
				
				}
		}
		estoque.setEstado(Estado.CANCELADA);
		return repository.save(estoque);
	}


}
