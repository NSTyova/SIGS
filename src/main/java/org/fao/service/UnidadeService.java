package org.fao.service;

import org.fao.model.Unidade;
import org.springframework.stereotype.Service;

@Service
public interface UnidadeService {

	public Unidade gravar(Unidade unidade);
}
