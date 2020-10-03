package pe.edu.upc.repositories;

import java.util.List;

import pe.edu.upc.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	List<Marca> findBynombreMarca(String marca) throws Exception;
}
