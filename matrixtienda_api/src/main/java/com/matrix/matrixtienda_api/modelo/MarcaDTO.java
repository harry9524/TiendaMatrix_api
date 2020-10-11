package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class MarcaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idMarca;
	private String nombreMarca;

	public MarcaDTO() {}

	public MarcaDTO(Integer idMarca, String nombreMarca) {
		super();
		this.idMarca = idMarca;
		this.nombreMarca = nombreMarca;
	}

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

	@Override
	public String toString() {
		return "MarcaDTO [idMarca=" + idMarca + ", nombreMarca=" + nombreMarca + "]";
	}

}
