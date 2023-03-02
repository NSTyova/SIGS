package org.fao.repository;

import java.util.Optional;

import org.fao.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Optional<Paciente> findByBilhete(String bilhete);
}
