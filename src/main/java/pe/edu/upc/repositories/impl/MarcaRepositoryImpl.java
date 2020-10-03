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
import pe.edu.upc.entities.Marca;
import pe.edu.upc.repositories.MarcaRepository;

@Named
@ApplicationScoped
public class MarcaRepositoryImpl implements  MarcaRepository,Serializable {


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Imporweb")
	private EntityManager em;

	@Override
	public Marca save(Marca entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Marca update(Marca entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Buscar el objeto a eliminar
		Optional<Marca> optional = findById(id);
		// Verificar que optional contenga un objeto categoria
		if( optional.isPresent() )
		// Remover el objeto contenido en el optional
		em.remove( optional.get() );
		
	}

	@Override
	public List<Marca> findAll() throws Exception {
		List<Marca> marcas = new ArrayList<Marca>();
		String qlString = "SELECT m FROM Marca m";	// JPQL
		TypedQuery<Marca> query = em.createQuery(qlString, Marca.class);
		marcas = query.getResultList();
		return marcas;
	}

	@Override
	public Optional<Marca> findById(Integer id) throws Exception {
		// Crear la variable a retornar
			Optional<Marca> marca = Optional.empty();
		// Crear la sentencia JPQL
			String qlString = "SELECT m FROM Marca m WHERE m.idMarca = ?1";	// JPQL
		// Crear la varible query basado en el JPQL y la clase
			TypedQuery<Marca> query = em.createQuery(qlString, Marca.class);
		// Establecer los parametros
			query.setParameter(1, id);
		// Obtener la lista resultante de la consulta
			List<Marca> marcas = query.getResultList();		
		// Si categorias tiene un elemento4
			if(marcas != null && !marcas.isEmpty())
			   marca = Optional.of( marcas.get(0) );
				return marca;
	}

	//buscar
		@Override
		public List<Marca> findBynombreMarca(String nombreMarca) throws Exception {
			List<Marca> marcas = new ArrayList<Marca>();
			String qlString = "SELECT m FROM Marca m WHERE m.nombreMarca LIKE ?1";	// JPQL
			TypedQuery<Marca> query = em.createQuery(qlString, Marca.class);
			query.setParameter(1, "%" + nombreMarca + "%");
			marcas = query.getResultList();
			return marcas;
		}
	
}
