package org.fao.repository;

import java.util.Optional;

import org.fao.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{

	Optional<Utilizador> findByNomeLogin(String nomeLogin);
	
}
