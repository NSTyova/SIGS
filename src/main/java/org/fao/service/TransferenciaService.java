package org.fao.service;

import org.fao.model.ItemTransferencia;
import org.fao.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public interface TransferenciaService {

	public Transferencia gravar(Transferencia transferencia);
	public Transferencia buscarOuFalhar(Long transferenciaId);
	public Page<ItemTransferencia> listar(Pageable paginacao);
	public Page<Transferencia>  buscarPorNome(Pageable paginacao,String nome);
}
