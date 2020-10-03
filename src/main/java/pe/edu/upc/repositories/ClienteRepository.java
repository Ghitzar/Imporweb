package pe.edu.upc.repositories;

import java.util.List;

import pe.edu.upc.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findBynombreCliente(String cliente) throws Exception;
}
