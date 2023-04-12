package org.fao.service.impl;

import java.util.List;

import org.fao.model.Deposito;
import org.fao.model.ItemEntradas;
import org.fao.model.ItemTransferencia;
import org.fao.model.Productos;
import org.fao.model.TipoProductos;
import org.fao.model.Transferencia;
import org.fao.model.exception.TransferenciaNaoEncontradoException;
import org.fao.repository.DepositoRepository;
import org.fao.repository.ItemEntradasRepository;
import org.fao.repository.ItemTransferenciaRepository;
import org.fao.repository.ProductosRepository;
import org.fao.repository.TipoProductosRepository;
import org.fao.repository.TransferenciaRepository;
import org.fao.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

	@Autowired
	private TransferenciaRepository repository;
	
	@Autowired
	private ItemEntradasRepository itemEntradasRepository;
	
	@Autowired
	private TipoProductosRepository tipoProductosRepository;
	
	@Autowired
	private  ProductosRepository productosRepository;
	
	@Autowired
	private ItemTransferenciaRepository itRepository;
	@Autowired
	private DepositoRepository depositoRepository;

	@Override
	public Transferencia gravar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		// GRAVAR A TRANSFERENCIA DO TRANSFERENCIA
		List<ItemTransferencia> iten = transferencia.getIten();
		iten.forEach(t -> t.setTransferencia(transferencia));

		// PEGAR O PRODUCTO, TIPO, LOTE
		for (ItemTransferencia item : transferencia.getIten()) {
			
			Long tipo = item.getTipo().getId();
			TipoProductos tipos = tipoProductosRepository.getById(tipo);
			Long produco = item.getProductos().getId();
			Productos prod = productosRepository.getById(produco);
			String lote = item.getLote();
			
			//Long origem = item.getTransferencia().getOrigem().getId();
			//Deposito dep =depositoRepository.getById(origem); // PDOE SER APENAS UMA CONDIÇÃO
			
			
			//AUMENTADO A CONDICAO PARA REVER A QUANTIDADE, AGORA FALTA PASSAR O DEPOSITO ORIGEM
			ItemEntradas itemEntradas = itemEntradasRepository.buscar(lote, prod, tipos);// item entradas
			itemEntradas.setQuantidadeActual(itemEntradas.getQuantidadeActual() - item.getQuantidade());
		
			

		}

		return repository.save(transferencia);
	}

	@Override
	public Transferencia buscarOuFalhar(Long transferenciaId) {
		// TODO Auto-generated method stub
		return repository.findById(transferenciaId).orElseThrow(() -> new TransferenciaNaoEncontradoException(transferenciaId));
	}

	@Override
	public Page<Transferencia> listar(Pageable paginacao) {
		// TODO Auto-generated method stub
		return repository.findAll(paginacao);
	}

	@Override
	public Page<Transferencia> buscarPorNome(Pageable paginacao, String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ItemTransferencia> buscarPorId(List<Transferencia> dto) {
		// TODO Auto-generated method stub
		return itRepository.findByIdIn(dto);
	}

}
