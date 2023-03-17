package org.fao.repository;

import java.util.Optional;

import org.fao.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{

	Optional<Utilizador> findByEmail(String nomeLogin);
	
}
