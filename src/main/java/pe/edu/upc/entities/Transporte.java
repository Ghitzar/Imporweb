package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transportes")
public class Transporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransporte;
	
	@Column(name = "nombreTransporte", nullable = false, length = 30)
	private String nombreTransporte;
	
	
	@Column(name = "nombreAgencia", nullable = false, length = 30)
	private String nombreAgencia;
	
	@Column(name = "tipo", nullable = false, length = 30)
	private String tipo;


	

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Integer getIdTransporte() {
		return idTransporte;
	}


	public void setIdTransporte(Integer idTransporte) {
		this.idTransporte = idTransporte;
	}


	public String getNombreTransporte() {
		return nombreTransporte;
	}


	public void setNombreTransporte(String nombreTransporte) {
		this.nombreTransporte = nombreTransporte;
	}


	public String getNombreAgencia() {
		return nombreAgencia;
	}


	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}

	public Transporte(Integer idTransporte, String nombreTransporte, String nombreAgencia, String tipo) {
		super();
		this.idTransporte = idTransporte;
		this.nombreTransporte = nombreTransporte;
		this.nombreAgencia = nombreAgencia;
		this.tipo = tipo;
	}


	public Transporte() {
		super();

	}
	
	
	
	

}
