package pe.edu.upc.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import pe.edu.upc.entities.Cliente;
import pe.edu.upc.repositories.ClienteRepository;
import pe.edu.upc.services.ClienteService;



public class ClienteServiceImpl implements ClienteService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteRepository clienteRepostory;

	@Transactional
	@Override
	public Cliente save(Cliente entity) throws Exception {
		return clienteRepostory.save(entity);
	}

	@Transactional
	@Override
	public Cliente update(Cliente entity) throws Exception {
		return clienteRepostory.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		clienteRepostory.deleteById(id);
		
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		return clienteRepostory.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		return clienteRepostory.findById(id);
	}

	@Override
	public List<Cliente> findBynombreCliente(String cliente) throws Exception {
		return clienteRepostory.findBynombreCliente(cliente);
		
	}

}
