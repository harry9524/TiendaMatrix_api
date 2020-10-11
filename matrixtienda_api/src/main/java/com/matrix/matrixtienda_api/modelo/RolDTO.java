package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class RolDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idRol;
	private String 	nombreRol;

	public RolDTO(Integer idRol, String nombreRol) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}
	
	public RolDTO() {}
	
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "RolDTO [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
	}

}
