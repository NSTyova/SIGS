package org.fao.repository;

import java.util.List;

import org.fao.model.ItemComprovante;
import org.fao.projections.CardsSaidaEntradaPaciente;
import org.fao.projections.ProductoEntregeCancelados;
import org.fao.projections.ProductosQTDSaidaDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemComprovanteRepository  extends JpaRepository<ItemComprovante, Long>{
	
	// PRODUCTOS ENTREGUES E CANCELADOS
		@Query("SELECT p.nome as productos, e.estado as estado, count(p.id) as qtd  FROM ItemComprovante ic INNER JOIN ic.productos p "
				+ " INNER JOIN ic.comprovante c INNER JOIN "
				+ " c.estoque e  "
				+ "WHERE e.utilizador.nomeLogin like :utilizador"
				+ " and e.dataRegistro= CONVERT (date, GETDATE()) "
				+ " GROUP BY p.nome , e.estado  ")
		List<ProductoEntregeCancelados> productos(String utilizador);
		
		// QUANTIDADE DE SAIDA, QUANTUDADE DE CANCELADAS E QUANDIDADE DE PACIENTES QUE LEVARAM CARDS
		
		//QUANTIDADE DE MEDICAMENTOS LEVADOS POR PACIENTES DIARIAMENTE
		/*@Query(" SELECT p.nome as producto, pa.nome as paciente, pa.bilhete as bilhete,  sum(ic.quantidade) as qtd "
				+ " FROM ItemComprovante ic INNER JOIN ic.productos p "
				+ " INNER JOIN ic.comprovante c INNER JOIN "
				+ " c.estoque e INNER JOIN e.paciente pa "
				+ " WHERE  e.dataRegistro= CONVERT (date, GETDATE())"
				+ " GROUP BY p.nome, pa.nome, pa.bilhete ")
		List<QTDMedPaciente> qtdMedPaciente();*/
		
		
		// PRODUCTOS MAIS SAIDOS POR DIA LIMITADO EM 10 LINHAS
		@Query( value = " SELECT top 10 p.nome as producto, sum(ic.quantidade) as qtd FROM tb_item_comprovante ic "
				+ " INNER JOIN tb_productos p ON (ic.productos=p.id_producto) "
				+ " INNER JOIN tb_comprovante c ON (ic.comprovante_id=c.id_comprovante) "
				+ " INNER JOIN tb_estoque e ON (c.estoque=e.id) "
				+ " INNER JOIN tb_utilizador u ON (e.utilizador =u.id) "
				+ " where e.estado='ENTREGUE' and "
				+ " e.data_registro= CONVERT(date, GETDATE()) and"
				+ "  u.nome_Login like :utilizador "
				+ " GROUP BY p.nome ",nativeQuery = true )
		List<ProductosQTDSaidaDia> limitados(String utilizador);

	// QUANTIDADE DE SAIDAS, CANCELADAS E POR PACIENTES DURANTE O DIA LEVADOS
		@Query(value = "SELECT COUNT(distinct p.id) as pacientes, "
				+ "(SELECT COUNT(*) FROM tb_estoque e "
				+ "INNER JOIN tb_utilizador u ON (e.utilizador =u.id) "
				+ "WHERE e.estado='ENTREGUE' and u.nome_Login like :utilizador "
				+ "	and e.data_registro= CONVERT(date, GETDATE())) as saidas, "
				+ "(SELECT  COUNT(*) FROM tb_estoque e "
				+ "INNER JOIN tb_utilizador u ON (e.utilizador =u.id) "
				+ " WHERE e.estado='CANCELADA' "
				+ "and u.nome_Login like :utilizador and e.data_registro= CONVERT(date, GETDATE())) as canceladas "
				+ "FROM tb_item_comprovante ic "
				+ "INNER JOIN tb_comprovante C ON (IC.comprovante_id=C.id_comprovante) "
				+ "INNER JOIN tb_estoque E ON (C.estoque=E.id) "
				+ "INNER JOIN tb_paciente P ON (E.paciente_id=P.id) "
				+ "INNER JOIN tb_utilizador u ON (E.utilizador =u.id)"
				+ "WHERE u.nome_Login like :utilizador and"
				+ " e.data_registro= CONVERT(date, GETDATE()) ", nativeQuery = true)		
		CardsSaidaEntradaPaciente cards(String utilizador);
		
		/*
		CREATE PROCEDURE alterar_estado
		AS
		BEGIN
		    UPDATE u 
		    SET u.estado_utilizador = 0
		    FROM tb_utilizador u
		    INNER JOIN tb_unidade ud ON u.unidades = ud.id
		    WHERE  ud.data_expiracao <= CONVERT (date, GETDATE())
		END
		;*/
}
