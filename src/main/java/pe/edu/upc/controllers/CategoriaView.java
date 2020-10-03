package pe.edu.upc.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import pe.edu.upc.entities.Categoria;

import pe.edu.upc.services.CategoriaService;
import pe.edu.upc.utils.Action;

@Named("categoriaView")		// Creando un Beans
@ViewScoped
public class CategoriaView implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Categoria> categorias;
	private Categoria categoria;
	private Categoria categoriaSelected;
	 private Categoria categoriaSearch;///buscar
	private Action action;
	
	
	@Inject
	private CategoriaService categoriaService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadCategorias();	
		action = Action.NONE;
		this.categoriaSearch= new Categoria();
		this.categoriaSelected= new Categoria();
		
	}

	public void loadCategorias() {
		try {
			this.categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	// Metodo para grabar el elemento ingresado en el formulario
	public void saveCategoria() {
		try {
			if (action == Action.NEW) {
				categoriaService.save(this.categoria);
			} 
			else if (action == Action.EDIT) {
				categoriaService.update(this.categoria);
			}	
			action = Action.NONE;
			cleanForm();
			loadCategorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	// Método que se ejecuta cuando hago click en 'Nuevo'
	public void newCategoria() {
		action = Action.NEW;
		cleanForm();
	}
	public void cleanForm( ) {
		this.categoria = new Categoria();
		this.categoriaSelected = null;		
	}
	// Metodo que se ejecuta cada vez que el usuario selecciona una fila del datatable
		public void selectCategoria(SelectEvent<Categoria> e) {
			this.categoriaSelected = e.getObject();
		}
		
		// Método que se ejecuta cuando hago click en el boton Editar
		public void editCategoria() {
			if(categoriaSelected != null) {
				action = Action.EDIT;
				categoria = categoriaSelected;
				categoriaSelected = null;
			}
		}
		
		// Método que se ejecuta cuando hace click en el boton 'Eliminar'
		public void deleteCategoria() {
			if(categoriaSelected != null) {
				try {
					categoriaService.deleteById(categoriaSelected.getIdCategoria());
					action = Action.NONE;
					cleanForm();
					loadCategorias();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println( e.getMessage() );
				}
			}
				
		}
		
		
	/////funcion para buscar 
		public void searchnombreCategoria() {
			try {
				this.categorias = categoriaService.findBynombreCategoria(categoriaSearch.getNombreCategoria());
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		////para limpiar la busqueda 
		public void cleanBynombreCategoria() {
			this.categoriaSearch.setNombreCategoria("");
			loadCategorias();
		//this.stateList();
		}
		
		
		
		public Categoria getCategoriaSearch() {
			return categoriaSearch;
		}

		public void setCategoriaSearch(Categoria categoriaSearch) {
			this.categoriaSearch = categoriaSearch;
		}

		public List<Categoria> getCategorias() {
			return categorias;
		}

		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Categoria getCategoriaSelected() {
			return categoriaSelected;
		}

		public void setCategoriaSelected(Categoria categoriaSelected) {
			this.categoriaSelected = categoriaSelected;
		}


	
}
