package pe.edu.upc.services;

import java.util.List;

import pe.edu.upc.entities.Empleado;

public interface EmpleadoService extends CrudService<Empleado, Integer>{
	List<Empleado> findBynombreEmpleado(String empleado) throws Exception;

}
