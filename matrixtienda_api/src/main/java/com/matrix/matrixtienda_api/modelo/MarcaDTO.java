package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class MarcaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idMarca;
	private String nombre;
	
	public MarcaDTO(Integer idMarca, String nombre) {
		this.idMarca = idMarca;
		this.nombre = nombre;
	}
	
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "MarcaDTO [idMarca=" + idMarca + ", nombre=" + nombre + "]";
	}
	
	
	
}
