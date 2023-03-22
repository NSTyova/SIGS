package org.fao.repository;

import org.fao.model.ItemDeposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDepositoRepository extends JpaRepository<ItemDeposito, Long>{

}
