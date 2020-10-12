package com.matrix.matrixtienda_api.modelo;

public class FiltersJuegoDTO{

	private Integer idRol;
	private Integer idPersona;
	private Integer idMarca;
	private Integer idJuego;
	
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public Integer getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}
	
	@Override
	public String toString() {
		return "FiltersJuegoDTO [idRol=" + idRol + ", idPersona=" + idPersona + ", idMarca=" + idMarca + ", idJuego="
				+ idJuego + "]";
	}
	
}
