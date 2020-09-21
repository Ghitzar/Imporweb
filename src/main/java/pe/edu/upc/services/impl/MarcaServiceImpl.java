package pe.edu.upc.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.edu.upc.entities.Marca;
import pe.edu.upc.repositories.MarcaRepository;
import pe.edu.upc.services.MarcaService;

@Named
@ApplicationScoped
public class MarcaServiceImpl implements MarcaService, Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private MarcaRepository marcaRepostory;

	@Transactional
	@Override
	public Marca save(Marca entity) throws Exception {
		return marcaRepostory.save(entity);
	}

	@Transactional
	@Override
	public Marca update(Marca entity) throws Exception {
		return marcaRepostory.update(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		marcaRepostory.deleteById(id);	
		
	}

	@Override
	public List<Marca> findAll() throws Exception {
		return marcaRepostory.findAll();
	}

	@Override
	public Optional<Marca> findById(Integer id) throws Exception {
		return marcaRepostory.findById(id);
	}

}
