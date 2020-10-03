package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Column(name = "nombreCliente", nullable = false, length = 20)
	private String nombreEmpleado;
	
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Column(name = "direccion", nullable = false, length = 8)
	private String direccion;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cliente(Integer idCliente, String nombreEmpleado, String dni, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombreEmpleado = nombreEmpleado;
		this.dni = dni;
		this.direccion = direccion;
	}

	public Cliente() {
		super();
		
	}
	
	
	
	
	
	
	
	
}
