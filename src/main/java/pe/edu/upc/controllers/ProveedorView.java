package pe.edu.upc.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.edu.upc.entities.Proveedor;
import pe.edu.upc.services.ProveedorService;
import pe.edu.upc.utils.Action;

@Named("proveedorView")		// Creando un Beans
@ViewScoped
public class ProveedorView implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private List<Proveedor> proveedores;
	private Proveedor proveedor;
	private Proveedor proveedorSelected;
	private Action action;
	

	@Inject
	private ProveedorService proveedorService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadProveedores();	
		action = Action.NONE;
	}

	public void loadProveedores() {
		try {
			this.proveedores = proveedorService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	// Metodo para grabar el elemento ingresado en el formulario
		public void saveProveedor() {
			try {
				if (action == Action.NEW) {
					proveedorService.save(this.proveedor);
				} 
				else if (action == Action.EDIT) {
					proveedorService.update(this.proveedor);
				}	
				action = Action.NONE;
				cleanForm();
				loadProveedores();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
		
		// Método que se ejecuta cuando hago click en 'Nuevo'
		public void newProveedor() {
			action = Action.NEW;
			cleanForm();
		}
		public void cleanForm( ) {
			this.proveedor = new Proveedor();
			this.proveedorSelected = null;		
		}
		// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
			public void selectProveedor(SelectEvent<Proveedor> e) {
				this.proveedorSelected = e.getObject();
			}
			
			// Método que se ejecuta cuando hago click en el boton Editar
			public void editProveedor() {
				if(proveedorSelected != null) {
					action = Action.EDIT;
					proveedor = proveedorSelected;
					proveedorSelected = null;
				}
			}
			
			// Método que se ejecuta cuando hace click en el boton 'Eliminar'
			public void deleteProveedor() {
				if(proveedorSelected != null) {
					try {
						proveedorService.deleteById(proveedorSelected.getIdProveedor());
						action = Action.NONE;
						cleanForm();
						loadProveedores();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.err.println( e.getMessage() );
					}
				}
					
			}

			public List<Proveedor> getProveedores() {
				return proveedores;
			}

			public void setProveedores(List<Proveedor> proveedores) {
				this.proveedores = proveedores;
			}

			public Proveedor getProveedor() {
				return proveedor;
			}

			public void setProveedor(Proveedor proveedor) {
				this.proveedor = proveedor;
			}

			public Proveedor getProveedorSelected() {
				return proveedorSelected;
			}

			public void setProveedorSelected(Proveedor proveedorSelected) {
				this.proveedorSelected = proveedorSelected;
			}
			
			
	
	
	
	
}
