package pe.edu.upc.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.edu.upc.entities.Empleado;
import pe.edu.upc.repositories.EmpleadoRepository;
import pe.edu.upc.services.EmpleadoService;



@Named
@ApplicationScoped
public class EmpleadoServiceImpl implements EmpleadoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpleadoRepository empleadoRepostory;

	@Transactional
	@Override
	public Empleado save(Empleado entity) throws Exception {
		return empleadoRepostory.save(entity);
	}

	@Transactional
	@Override
	public Empleado update(Empleado entity) throws Exception {
		return empleadoRepostory.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		empleadoRepostory.deleteById(id);
		
	}

	@Override
	public List<Empleado> findAll() throws Exception {
		return empleadoRepostory.findAll();
	}

	@Override
	public Optional<Empleado> findById(Integer id) throws Exception {
		return empleadoRepostory.findById(id);
	}

	@Override
	public List<Empleado> findBynombreEmpleado(String empleado) throws Exception {
		return empleadoRepostory.findBynombreEmpleado(empleado);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
