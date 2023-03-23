package org.fao.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fao.model.Entradas;
import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;
import org.fao.model.ItemSolicitacao;
import org.fao.model.Saidas;
import org.fao.model.Solicitacao;
import org.fao.repository.EntradasRepository;
import org.fao.repository.SaidasRepository;
import org.fao.repository.SolicitacaoRepository;
import org.fao.service.SaidasService;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaidaServiceImpl implements SaidasService {

	@Autowired
	private SaidasRepository repository;

	@Autowired
	private EntradasRepository entradaRepository;

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	@Override
	public Saidas gravar(Saidas saidas) {

		// GRAVAR O ID QUE VEM NA SAIDA E GRAVAR NO ITEM-SAIDAS
		List<ItemSaida> iten = saidas.getIten();
		iten.forEach(s -> s.setSaidas(saidas));

		// PEGAR O ID DA LISTAR E PASSAR A ENTRADA
		Long id = saidas.getEntradas().getId();
		Entradas entradas = entradaRepository.getById(id);

		// PEGAR O ID DA LISTA E PASSAR NA SOLICITACAO
		Long ids = saidas.getSolicitacao().getId();
		Solicitacao solicitacao = solicitacaoRepository.getById(ids);
		for (ItemEntradas ie : entradas.getIten()) {
			for (ItemSolicitacao ise : solicitacao.getItem()) {
				if (ise.getProductos().equals(ie.getProductos()) && ise.getTipo().equals(ie.getTipo())) {
					ie.setQuantidadeActual(ie.getQuantidadeActual() );
				}

			}
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
