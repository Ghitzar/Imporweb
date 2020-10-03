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
import pe.edu.upc.entities.Cliente;
import pe.edu.upc.repositories.ClienteRepository;


@Named
@ApplicationScoped
public class ClienteRepositoryImpl implements  ClienteRepository,Serializable {


	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "Imporweb")
	private EntityManager em;
	
	@Override
	public Cliente save(Cliente entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Buscar el objeto a eliminar
			Optional<Cliente> optional = findById(id);
		// Verificar que optional contenga un objeto categoria
			if( optional.isPresent() )
		// Remover el objeto contenido en el optional
				    em.remove( optional.get() );
		
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String qlString = "SELECT cl FROM Cliente cl";	// JPQL
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		clientes = query.getResultList();
		return clientes;
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// Crear la variable a retornar
					Optional<Cliente> cliente = Optional.empty();
				// Crear la sentencia JPQL
					String qlString = "SELECT cl FROM Cliente cl WHERE cl.idCliente = ?1";	// JPQL
				// Crear la varible query basado en el JPQL y la clase
					TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
				// Establecer los parametros
					query.setParameter(1, id);
				// Obtener la lista resultante de la consulta
					List<Cliente> clientes = query.getResultList();		
				// Si empleado tiene un elemento4
					if(clientes != null && !clientes.isEmpty())
						cliente = Optional.of( clientes.get(0) );
						  return cliente;
			}

	//buscar
		@Override
		public List<Cliente> findBynombreCliente(String nombreCliente) throws Exception {
			List<Cliente> clientes = new ArrayList<Cliente>();
			String qlString = "SELECT cl FROM Cliente cl WHERE cl.nombreCliente LIKE ?1";	// JPQL
			TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
			query.setParameter(1, "%" + nombreCliente + "%");
			clientes = query.getResultList();
			return clientes;
		}
	
	
	
}
