package pe.edu.upc.repositories;

import java.util.List;

import pe.edu.upc.entities.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Integer>{
	List<Transporte> findByTipo(String transporte) throws Exception;

}