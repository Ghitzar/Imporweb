package pe.edu.upc.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.edu.upc.entities.Cliente;
import pe.edu.upc.services.ClienteService;
import pe.edu.upc.utils.Action;



@Named("clienteView")		// Creando un Beans
@ViewScoped
public class ClienteView implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes;
	private Cliente cliente;
	private Cliente clienteSelected;
	private Cliente clienteSearch;///buscar
	private Action action;
	
	@Inject
	private ClienteService clienteService;
	
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadClientes();	
		action = Action.NONE;
		this.clienteSearch= new Cliente();
		this.clienteSelected= new Cliente();
	}
	
	public void loadClientes() {
		try {
			this.clientes = clienteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	
	// Metodo para grabar el elemento ingresado en el formulario
		public void saveCliente() {
			try {
				if (action == Action.NEW) {
					clienteService.save(this.cliente);
				} 
				else if (action == Action.EDIT) {
					clienteService.update(this.cliente);
				}	
				action = Action.NONE;
				cleanForm();
				loadClientes();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
		
		// Método que se ejecuta cuando hago click en 'Nuevo'
		public void newCliente() {
			action = Action.NEW;
			cleanForm();
		}
		public void cleanForm( ) {
			this.cliente = new Cliente();
			this.clienteSelected = null;		
		}
		// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
			public void selectCliente(SelectEvent<Cliente> e) {
				this.clienteSelected = e.getObject();
			}
			
			// Método que se ejecuta cuando hago click en el boton Editar
			public void editCliente() {
				if(clienteSelected != null) {
					action = Action.EDIT;
					cliente = clienteSelected;
					clienteSelected = null;
				}
			}
			
			// Método que se ejecuta cuando hace click en el boton 'Eliminar'
			public void deleteCliente() {
				if(clienteSelected != null) {
					try {
						clienteService.deleteById(clienteSelected.getIdCliente());
						action = Action.NONE;
						cleanForm();
						loadClientes();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.err.println( e.getMessage() );
					}
				}
					
			}
			
			/////funcion para buscar 
			public void searchnombreCliente() {
				try {
					this.clientes = clienteService.findBynombreCliente(clienteSearch.getNombreCliente());
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
			}
			////para limpiar la busqueda 
			public void cleanBynombreCliente() {
				this.clienteSearch.setNombreCliente("");
				loadClientes();
			//this.stateList();
			}
			

			public Cliente getClienteSearch() {
				return clienteSearch;
			}

			public void setClienteSearch(Cliente clienteSearch) {
				this.clienteSearch = clienteSearch;
			}

			public List<Cliente> getClientes() {
				return clientes;
			}

			public void setClientes(List<Cliente> clientes) {
				this.clientes = clientes;
			}

			public Cliente getCliente() {
				return cliente;
			}

			public void setCliente(Cliente cliente) {
				this.cliente = cliente;
			}

			public Cliente getClienteSelected() {
				return clienteSelected;
			}

			public void setClienteSelected(Cliente clienteSelected) {
				this.clienteSelected = clienteSelected;
			}
			
			
			
			
	
	
	
	
}
