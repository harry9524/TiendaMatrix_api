package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class PlataformaDTO implements Serializable{

private static final long serialVersionUID = 1L;
	
	private Integer idPlataforma;
	private String nombre;
	
	public PlataformaDTO(Integer idPlataforma, String nombre) {
		super();
		this.idPlataforma = idPlataforma;
		this.nombre = nombre;
	}
	
	public Integer getIdPlataforma() {
		return idPlataforma;
	}
	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "PlataformaDTO [idPlataforma=" + idPlataforma + ", nombre=" + nombre + "]";
	}
	
}
