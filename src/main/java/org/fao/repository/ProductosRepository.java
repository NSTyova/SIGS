package org.fao.repository;

import org.fao.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long>{
/*
	// pesquisar pelo codigo para o estoque
	
	Page<Productos> findByCodigo(Pageable paginacao,String codigo);
	Optional<Productos> findByCodigo(String codigo);
	
	// FAZER AQUI UM METODO QUE PEGA A LISTA DOS PRODUCTOS E COM PARAMETROS 
	//List<Productos> listarId();

	@Query("select p from Productos p where p.id=:id")
	Productos buscarListaId(@Param("id")List<Productos> producto);
	
	
	// QTD DE PRODCUTOS POR CATEGORIAS
	@Query("SELECT distinct c.descricao as categoria, count(p.id) as qtd"
			+ " FROM Productos p INNER JOIN p.categoria c"
			//where  e.dataRegistro= CONVERT (date, GETDATE()) ACRESCENTAR AQUI SE FOR NECESSARIO
			+ " GROUP BY c.descricao ")
	public List<ProductosCategorias> qtdProductos();*/
}
