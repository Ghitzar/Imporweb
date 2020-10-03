package pe.edu.upc.repositories;

import java.util.List;

import pe.edu.upc.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	List<Empleado> findBynombreEmpleado(String empleado) throws Exception;
}
