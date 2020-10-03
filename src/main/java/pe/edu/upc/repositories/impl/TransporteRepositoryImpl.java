package pe.edu.upc.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.edu.upc.entities.Transporte;
import pe.edu.upc.repositories.TransporteRepository;



@Named
@ApplicationScoped
public class TransporteRepositoryImpl implements  TransporteRepository,Serializable {


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Imporweb")
	private EntityManager em;


	@Override
	public Transporte save(Transporte entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Transporte update(Transporte entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Buscar el objeto a eliminar
			Optional<Transporte> optional = findById(id);
		// Verificar que optional contenga un objeto transporte
			if( optional.isPresent() )
		// Remover el objeto contenido en el optional
		    em.remove( optional.get() );
		
	}

	@Override
	public List<Transporte> findAll() throws Exception {
		List<Transporte> transportes = new ArrayList<Transporte>();
		String qlString = "SELECT t FROM Transporte t";	// JPQL
		TypedQuery<Transporte> query = em.createQuery(qlString, Transporte.class);
		transportes = query.getResultList();
		return transportes;		
	}

	@Override
	public Optional<Transporte> findById(Integer id) throws Exception {
	// Crear la variable a retornar
		Optional<Transporte> transporte = Optional.empty();
	// Crear la sentencia JPQL
		String qlString = "SELECT t FROM Transporte t WHERE t.idTransporte = ?1";	// JPQL
	// Crear la varible query basado en el JPQL y la clase
		TypedQuery<Transporte> query = em.createQuery(qlString, Transporte.class);
	// Establecer los parametros
		query.setParameter(1, id);
	// Obtener la lista resultante de la consulta
		List<Transporte> transportes = query.getResultList();		
	// Si transportes tiene un elemento4
		if(transportes != null && !transportes.isEmpty())
			transporte = Optional.of( transportes.get(0) );
			return transporte;
	}

	
	//buscar
		@Override
		public List<Transporte> findByTipo(String tipo) throws Exception {
			List<Transporte> transportes = new ArrayList<Transporte>();
			String qlString = "SELECT t FROM Transporte t WHERE t.tipo LIKE ?1";	// JPQL
			TypedQuery<Transporte> query = em.createQuery(qlString, Transporte.class);
			query.setParameter(1, "%" + tipo + "%");
			transportes = query.getResultList();
			return transportes;
		}
}
