package com.test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Ruc cannot be null or empty")
	@Size(max = 11, message = "Ruc must be 11 characteres")
	@Column(unique = true) 
	private String ruc;
	
	@NotBlank(message = "RazonSocial cannot be null or empty")
	private String razonSocial;
	
	@NotBlank(message = "Address cannot be null or empty")
	private String direccion;
	
	@NotBlank(message = "State cannot be null or empty")
	@Size(max = 1, message = "state must be 1 characteres 1=active,0=inactive")
	private String estado;
	
	public Empresa() {
	}

	
	public Empresa(int id,
			@NotBlank(message = "Ruc cannot be null or empty") @Size(max = 11, message = "Ruc must be 11 characteres") String ruc,
			@NotBlank(message = "RazonSocial cannot be null or empty") String razonSocial,
			@NotBlank(message = "Address cannot be null or empty") String direccion,
			@NotBlank(message = "State cannot be null or empty") @Size(max = 1, message = "state must be 1 characteres 1=active,0=inactive") String estado) {
		super();
		this.id = id;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.estado = estado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
