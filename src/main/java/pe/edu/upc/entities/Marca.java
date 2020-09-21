package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;

	
	@Column(name = "nombreMarca", nullable = false, length = 20)
	private String nombreMarca;

	
	@Column(name = "nombreEmpresa", nullable = false, length = 20)
	private String nombreEmpresa;



	public Integer getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}


	public String getNombreMarca() {
		return nombreMarca;
	}


	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public Marca(Integer idMarca, String nombreMarca, String nombreEmpresa) {
		super();
		this.idMarca = idMarca;
		this.nombreMarca = nombreMarca;
		this.nombreEmpresa = nombreEmpresa;
	}


	public Marca() {
		super();
	}


	

	
	
	
	
	
	
	

}
