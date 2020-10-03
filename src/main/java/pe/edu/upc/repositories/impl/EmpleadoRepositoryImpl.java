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
import pe.edu.upc.entities.Empleado;
import pe.edu.upc.repositories.EmpleadoRepository;



@Named
@ApplicationScoped
public class EmpleadoRepositoryImpl implements  EmpleadoRepository,Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Imporweb")
	private EntityManager em;

	@Override
	public Empleado save(Empleado entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Empleado update(Empleado entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Buscar el objeto a eliminar
			Optional<Empleado> optional = findById(id);
		// Verificar que optional contenga un objeto categoria
			if( optional.isPresent() )
		// Remover el objeto contenido en el optional
		    em.remove( optional.get() );
		
	}

	@Override
	public List<Empleado> findAll() throws Exception {
		List<Empleado> empleados = new ArrayList<Empleado>();
		String qlString = "SELECT e FROM Empleado e";	// JPQL
		TypedQuery<Empleado> query = em.createQuery(qlString, Empleado.class);
		empleados = query.getResultList();
		return empleados;
	}

	@Override
	public Optional<Empleado> findById(Integer id) throws Exception {
		// Crear la variable a retornar
			Optional<Empleado> empleado = Optional.empty();
		// Crear la sentencia JPQL
			String qlString = "SELECT e FROM Empleado e WHERE e.idEmpleado = ?1";	// JPQL
		// Crear la varible query basado en el JPQL y la clase
			TypedQuery<Empleado> query = em.createQuery(qlString, Empleado.class);
		// Establecer los parametros
			query.setParameter(1, id);
		// Obtener la lista resultante de la consulta
			List<Empleado> empleados = query.getResultList();		
		// Si empleado tiene un elemento4
			if(empleados != null && !empleados.isEmpty())
				empleado = Optional.of( empleados.get(0) );
				  return empleado;
	}
	//buscar
		@Override
		public List<Empleado> findBynombreEmpleado(String nombreEmpleado) throws Exception {
			List<Empleado> empleados = new ArrayList<Empleado>();
			String qlString = "SELECT e FROM Empleado e WHERE e.nombreEmpleado LIKE ?1";	// JPQL
			TypedQuery<Empleado> query = em.createQuery(qlString, Empleado.class);
			query.setParameter(1, "%" + nombreEmpleado + "%");
			empleados = query.getResultList();
			return empleados;
		}

}
