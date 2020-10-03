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
import pe.edu.upc.entities.Proveedor;
import pe.edu.upc.repositories.ProveedorRepository;



@Named
@ApplicationScoped
public class ProveedorRepositoryImpl implements ProveedorRepository, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Imporweb")
	private EntityManager em;

	@Override
	public Proveedor save(Proveedor entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Proveedor update(Proveedor entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Buscar el objeto a eliminar
		    Optional<Proveedor> optional = findById(id);
		// Verificar que optional contenga un objeto categoria
			if( optional.isPresent() )
		// Remover el objeto contenido en el optional
		   em.remove( optional.get() );
		
	}

	@Override
	public List<Proveedor> findAll() throws Exception {
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		String qlString = "SELECT p FROM Proveedor p";	// JPQL
		TypedQuery<Proveedor> query = em.createQuery(qlString, Proveedor.class);
		proveedores = query.getResultList();
		return proveedores;
	}

	@Override
	public Optional<Proveedor> findById(Integer id) throws Exception {
		// Crear la variable a retornar
			Optional<Proveedor> proveedor = Optional.empty();
		// Crear la sentencia JPQL
			String qlString = "SELECT p FROM Proveedor p WHERE p.idProveedor = ?1";	// JPQL
		// Crear la varible query basado en el JPQL y la clase
			 TypedQuery<Proveedor> query = em.createQuery(qlString, Proveedor.class);
		// Establecer los parametros
			query.setParameter(1, id);
		// Obtener la lista resultante de la consulta
			List<Proveedor> proveedores = query.getResultList();
						
	    // Si proveedore tiene un elemento4
			if(proveedores != null && !proveedores.isEmpty())
				proveedor = Optional.of( proveedores.get(0) );
			return proveedor;
	}

	
	
	//buscar
		@Override
		public List<Proveedor> findBynombreProveedor(String nombreProveedor) throws Exception {
			List<Proveedor> proveedores = new ArrayList<Proveedor>();
			String qlString = "SELECT p FROM Proveedor p WHERE p.nombreProveedor LIKE ?1";	// JPQL
			TypedQuery<Proveedor> query = em.createQuery(qlString, Proveedor.class);
			query.setParameter(1, "%" + nombreProveedor + "%");
			proveedores = query.getResultList();
			return proveedores;
		}
}
