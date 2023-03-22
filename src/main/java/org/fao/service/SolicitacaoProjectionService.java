package org.fao.service;

import java.math.BigDecimal;
import java.util.List;

import org.fao.service.projections.SolicitadaoSaidaProjections;
import org.springframework.stereotype.Service;

@Service
public interface SolicitacaoProjectionService {

	List<SolicitadaoSaidaProjections> buscar(Long producto, Long tipo, Long deposito, BigDecimal gramas);
}
