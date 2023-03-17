package org.fao.service;

import org.fao.model.Deposito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DepositoService {

	public Deposito gravar(Deposito deposito);
	public Deposito buscarOuFalhar(Long depositoId);
	public Page<Deposito> listar(Pageable paginacao);
	public Page<Deposito>  buscarPorNome(Pageable paginacao,String nome);
}
