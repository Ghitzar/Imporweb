package pe.edu.upc.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.edu.upc.entities.Marca;
import pe.edu.upc.services.MarcaService;
import pe.edu.upc.utils.Action;

@Named("marcaView")		// Creando un Beans
@ViewScoped
public class MarcaView implements Serializable{


	private static final long serialVersionUID = 1L;

	private List<Marca> marcas;
	private Marca marca;
	private Marca marcaSelected;
	private Action action;
	
	@Inject
	private MarcaService marcaService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadMarcas();	
		action = Action.NONE;
	}
	
	public void loadMarcas() {
		try {
			this.marcas = marcaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	// Metodo para grabar el elemento ingresado en el formulario
		public void saveMarca() {
			try {
				if (action == Action.NEW) {
					marcaService.save(this.marca);
				} 
				else if (action == Action.EDIT) {
					marcaService.update(this.marca);
				}	
				action = Action.NONE;
				cleanForm();
				loadMarcas();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
		
		// Método que se ejecuta cuando hago click en 'Nuevo'
		public void newMarca() {
			action = Action.NEW;
			cleanForm();
		}
		public void cleanForm( ) {
			this.marca = new Marca();
			this.marcaSelected = null;		
		}
		// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
			public void selectMarca(SelectEvent<Marca> e) {
				this.marcaSelected = e.getObject();
			}
			
			// Método que se ejecuta cuando hago click en el boton Editar
			public void editMarca() {
				if(marcaSelected != null) {
					action = Action.EDIT;
					marca = marcaSelected;
					marcaSelected = null;
				}
			}
			
			// Método que se ejecuta cuando hace click en el boton 'Eliminar'
			public void deleteMarca() {
				if(marcaSelected != null) {
					try {
						marcaService.deleteById(marcaSelected.getIdMarca());
						action = Action.NONE;
						cleanForm();
						loadMarcas();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.err.println( e.getMessage() );
					}
				}
					
			}
			
	
	
	
	
	
	
	

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Marca getMarcasSelected() {
		return marcaSelected;
	}

	public void setMarcasSelected(Marca marcasSelected) {
		this.marcaSelected = marcasSelected;
	}
	
	
	
	
	
}
