package pe.edu.upc.repositories;

import java.util.List;

import pe.edu.upc.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {
	List<Categoria> findBynombreCategoria(String categoria) throws Exception;

}
