package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class PlataformaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idPlataforma;
	private String nombrePlataforma;

	public PlataformaDTO(Integer idPlataforma, String nombrePlataforma) {
		super();
		this.idPlataforma = idPlataforma;
		this.nombrePlataforma = nombrePlataforma;
	}

	public PlataformaDTO() {}
	
	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	@Override
	public String toString() {
		return "PlataformaDTO [idPlataforma=" + idPlataforma + ", nombrePlataforma=" + nombrePlataforma + "]";
	}

}
