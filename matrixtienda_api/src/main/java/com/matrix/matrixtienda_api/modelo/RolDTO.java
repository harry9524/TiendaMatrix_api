package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class RolDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private Integer idRol;
	private String nombre;
	
	public RolDTO(Integer idRol, String nombre) {
		this.idRol = idRol;
		this.nombre = nombre;
	}
	
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "RolDTO [idRol=" + idRol + ", nombre=" + nombre + "]";
	}
	
}
