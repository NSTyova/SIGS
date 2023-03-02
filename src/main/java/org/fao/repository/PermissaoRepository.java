package org.fao.repository;

import org.fao.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

}
