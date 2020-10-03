package pe.edu.upc.services;

import java.util.List;

import pe.edu.upc.entities.Categoria;

public interface CategoriaService extends CrudService<Categoria, Integer> {
	List<Categoria> findBynombreCategoria(String categoria) throws Exception;
}
