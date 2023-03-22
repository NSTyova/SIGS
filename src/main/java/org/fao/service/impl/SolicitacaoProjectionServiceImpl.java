package org.fao.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.fao.repository.ItemEntradasRepository;
import org.fao.service.SolicitacaoProjectionService;
import org.fao.service.projections.SolicitadaoSaidaProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SolicitacaoProjectionServiceImpl implements SolicitacaoProjectionService {

	@Autowired
	private ItemEntradasRepository repository;
	
	@Override
	public List<SolicitadaoSaidaProjections> buscar(Long producto, Long tipo, Long deposito, BigDecimal gramas) {
		// TODO Auto-generated method stub
		return repository.listaSaidas(producto, tipo, deposito, gramas);
	}

}
