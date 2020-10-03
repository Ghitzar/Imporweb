package pe.edu.upc.repositories;

import java.util.List;

import pe.edu.upc.entities.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
	List<Proveedor> findBynombreProveedor(String proveedor) throws Exception;


}
