package pe.edu.upc.services;

import java.util.List;

import pe.edu.upc.entities.Proveedor;

public interface ProveedorService extends CrudService<Proveedor, Integer> {
	
	List<Proveedor> findBynombreProveedor(String proveedor) throws Exception;

}
