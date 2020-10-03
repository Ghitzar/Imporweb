package pe.edu.upc.services;

import java.util.List;

import pe.edu.upc.entities.Transporte;

public interface TransporteService extends CrudService<Transporte, Integer>{
	
	List<Transporte> findByTipo(String transporte) throws Exception;

}
