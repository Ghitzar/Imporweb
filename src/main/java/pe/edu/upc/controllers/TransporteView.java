package pe.edu.upc.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.edu.upc.entities.Transporte;
import pe.edu.upc.services.TransporteService;
import pe.edu.upc.utils.Action;

@Named("transporteView")		// Creando un Beans
@ViewScoped
public class TransporteView implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Transporte> transportes;
	private Transporte transporte;
	private Transporte transporteSelected;
	private Action action;
	
	@Inject
	private TransporteService transporteService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadTransportes();	
		action = Action.NONE;
	}
	
	public void loadTransportes() {
		try {
			this.transportes = transporteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
		
	// Metodo para grabar el elemento ingresado en el formulario
			public void saveTransporte() {
				try {
					if (action == Action.NEW) {
						transporteService.save(this.transporte);
					} 
					else if (action == Action.EDIT) {
						transporteService.update(this.transporte);
					}	
					action = Action.NONE;
					cleanForm();
					loadTransportes();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println( e.getMessage() );
				}
			}
			
			// Método que se ejecuta cuando hago click en 'Nuevo'
			public void newTransporte() {
				action = Action.NEW;
				cleanForm();
			}
			public void cleanForm( ) {
				this.transporte = new Transporte();
				this.transporteSelected = null;		
			}
			// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
				public void selectTransporte(SelectEvent<Transporte> e) {
					this.transporteSelected = e.getObject();
				}
				
				// Método que se ejecuta cuando hago click en el boton Editar
				public void editTransporte() {
					if(transporteSelected != null) {
						action = Action.EDIT;
						transporte = transporteSelected;
						transporteSelected = null;
					}
				}
				
				// Método que se ejecuta cuando hace click en el boton 'Eliminar'
				public void deleteTransporte() {
					if(transporteSelected != null) {
						try {
							transporteService.deleteById(transporteSelected.getIdTransporte());
							action = Action.NONE;
							cleanForm();
							loadTransportes();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.err.println( e.getMessage() );
						}
					}
						
				}

				public List<Transporte> getTransportes() {
					return transportes;
				}

				public void setTransportes(List<Transporte> transportes) {
					this.transportes = transportes;
				}

				public Transporte getTransporte() {
					return transporte;
				}

				public void setTransporte(Transporte transporte) {
					this.transporte = transporte;
				}

				public Transporte getTransporteSelected() {
					return transporteSelected;
				}

				public void setTransporteSelected(Transporte transporteSelected) {
					this.transporteSelected = transporteSelected;
				}
				
	
				
				
				
				

}
