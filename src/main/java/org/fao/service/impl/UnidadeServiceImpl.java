package org.fao.service.impl;

import org.fao.model.Unidade;
import org.fao.repository.UnidadeRepository;
import org.fao.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeServiceImpl implements UnidadeService {

	@Autowired
	private UnidadeRepository repository;
	
	@Override
	public Unidade gravar(Unidade unidade) {
		return repository.save(unidade);
	}

}
