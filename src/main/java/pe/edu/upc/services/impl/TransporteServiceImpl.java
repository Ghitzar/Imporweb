package pe.edu.upc.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.edu.upc.entities.Transporte;
import pe.edu.upc.repositories.TransporteRepository;
import pe.edu.upc.services.TransporteService;



@Named
@ApplicationScoped
public class TransporteServiceImpl implements TransporteService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private TransporteRepository transporteRepostory;

	@Transactional
	@Override
	public Transporte save(Transporte entity) throws Exception {
		return transporteRepostory.save(entity);
	}

	@Transactional
	@Override
	public Transporte update(Transporte entity) throws Exception {
		return transporteRepostory.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		transporteRepostory.deleteById(id);
		
	}

	@Override
	public List<Transporte> findAll() throws Exception {
		return transporteRepostory.findAll();
	}

	@Override
	public Optional<Transporte> findById(Integer id) throws Exception {
		return transporteRepostory.findById(id);
	}

	@Override
	public List<Transporte> findByTipo(String transporte) throws Exception {
		return transporteRepostory.findByTipo(transporte);
	}

}
