package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	

	@Column(name = "nombreProveedor", nullable = false, length = 20)
	private String nombreProveedor;
	
	@Column(name = "telefono", nullable = false, length = 20)
	private String telefono;
	
	@Column(name = "email", nullable = false, length = 20)
	private String email;

	public Integer getIdProveedor() {
		return idProveedor;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}


	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	


	public Proveedor(Integer idProveedor, String nombreProveedor, String telefono, String email) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.telefono = telefono;
		this.email = email;
	}


	public Proveedor() {
		super();
		
	}
	
	

}
