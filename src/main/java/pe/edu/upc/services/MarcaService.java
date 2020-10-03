package pe.edu.upc.services;

import java.util.List;

import pe.edu.upc.entities.Marca;

public interface MarcaService extends CrudService<Marca, Integer>{
	List<Marca> findBynombreMarca(String marca) throws Exception;
}
