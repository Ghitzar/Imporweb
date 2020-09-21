package pe.edu.upc.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.edu.upc.entities.Empleado;
import pe.edu.upc.services.EmpleadoService;
import pe.edu.upc.utils.Action;

@Named("empleadoView")		// Creando un Beans
@ViewScoped
public class EmpleadoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Empleado> empleados;
	private Empleado empleado;
	private Empleado empleadoSelected;
	private Action action;
	
	@Inject
	private EmpleadoService empleadoService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadEmpleados();	
		action = Action.NONE;
	}
	
	public void loadEmpleados() {
		try {
			this.empleados = empleadoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	// Metodo para grabar el elemento ingresado en el formulario
	public void saveEmpleado() {
		try {
			if (action == Action.NEW) {
				empleadoService.save(this.empleado);
			} 
			else if (action == Action.EDIT) {
				empleadoService.update(this.empleado);
			}	
			action = Action.NONE;
			cleanForm();
			loadEmpleados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	// Método que se ejecuta cuando hago click en 'Nuevo'
	public void newEmpleado() {
		action = Action.NEW;
		cleanForm();
	}
	public void cleanForm( ) {
		this.empleado = new Empleado();
		this.empleadoSelected = null;		
	}
	// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
		public void selectEmpleado(SelectEvent<Empleado> e) {
			this.empleadoSelected = e.getObject();
		}
		
		// Método que se ejecuta cuando hago click en el boton Editar
		public void editEmpleado() {
			if(empleadoSelected != null) {
				action = Action.EDIT;
				empleado = empleadoSelected;
				empleadoSelected = null;
			}
		}
		
		// Método que se ejecuta cuando hace click en el boton 'Eliminar'
		public void deleteEmpleado() {
			if(empleadoSelected != null) {
				try {
					empleadoService.deleteById(empleadoSelected.getIdEmpleado());
					action = Action.NONE;
					cleanForm();
					loadEmpleados();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println( e.getMessage() );
				}
			}
				
		}

		public List<Empleado> getEmpleados() {
			return empleados;
		}

		public void setEmpleados(List<Empleado> empleados) {
			this.empleados = empleados;
		}

		public Empleado getEmpleado() {
			return empleado;
		}

		public void setEmpleado(Empleado empleado) {
			this.empleado = empleado;
		}

		public Empleado getEmpleadoSelected() {
			return empleadoSelected;
		}

		public void setEmpleadoSelected(Empleado empleadoSelected) {
			this.empleadoSelected = empleadoSelected;
		}
	
	


}
