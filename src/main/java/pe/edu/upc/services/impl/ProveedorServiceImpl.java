package pe.edu.upc.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.edu.upc.entities.Proveedor;
import pe.edu.upc.repositories.ProveedorRepository;
import pe.edu.upc.services.ProveedorService;



@Named
@ApplicationScoped
public class ProveedorServiceImpl implements ProveedorService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorRepository proveedorRepostory;

	@Transactional
	@Override
	public Proveedor save(Proveedor entity) throws Exception {
		return proveedorRepostory.save(entity);
	}

	@Transactional
	@Override
	public Proveedor update(Proveedor entity) throws Exception {
		return proveedorRepostory.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		proveedorRepostory.deleteById(id);
		
	}

	@Override
	public List<Proveedor> findAll() throws Exception {
		return proveedorRepostory.findAll();
	}

	@Override
	public Optional<Proveedor> findById(Integer id) throws Exception {
		return proveedorRepostory.findById(id);
	}

}
