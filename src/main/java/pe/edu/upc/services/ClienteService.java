package pe.edu.upc.services;

import java.util.List;

import pe.edu.upc.entities.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer>{
	List<Cliente> findBynombreCliente(String cliente) throws Exception;

}
