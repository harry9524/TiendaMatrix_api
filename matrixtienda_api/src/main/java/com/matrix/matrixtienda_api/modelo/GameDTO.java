package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;
import java.util.Date;

public class GameDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idJuego;
	private String 	nombreJuego;
	private String 	descripcionJuego;
	private Integer precioJuegoJuego;
	private Integer precioAlquilerJuego;
	private Integer idMarca;
	private Date 	fechaLanzamientoJuego;

	public GameDTO() {}

	public GameDTO(Integer idJuego, String nombreJuego, String descripcionJuego, Integer precioJuegoJuego,
			Integer precioAlquilerJuego, Integer idMarca, Date fechaLanzamientoJuego) {
		this.idJuego = idJuego;
		this.nombreJuego = nombreJuego;
		this.descripcionJuego = descripcionJuego;
		this.precioJuegoJuego = precioJuegoJuego;
		this.precioAlquilerJuego = precioAlquilerJuego;
		this.idMarca = idMarca;
		this.fechaLanzamientoJuego = fechaLanzamientoJuego;
	}

	public Integer getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}
	public String getNombreJuego() {
		return nombreJuego;
	}
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
	public String getDescripcionJuego() {
		return descripcionJuego;
	}
	public void setDescripcionJuego(String descripcionJuego) {
		this.descripcionJuego = descripcionJuego;
	}
	public Integer getPrecioJuegoJuego() {
		return precioJuegoJuego;
	}
	public void setPrecioJuegoJuego(Integer precioJuegoJuego) {
		this.precioJuegoJuego = precioJuegoJuego;
	}
	public Integer getPrecioAlquilerJuego() {
		return precioAlquilerJuego;
	}
	public void setPrecioAlquilerJuego(Integer precioAlquilerJuego) {
		this.precioAlquilerJuego = precioAlquilerJuego;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public Date getFechaLanzamientoJuego() {
		return fechaLanzamientoJuego;
	}
	public void setFechaLanzamientoJuego(Date fechaLanzamientoJuego) {
		this.fechaLanzamientoJuego = fechaLanzamientoJuego;
	}

	@Override
	public String toString() {
		return "GameDTO [idJuego=" + idJuego + ", nombreJuego=" + nombreJuego + ", descripcionJuego=" + descripcionJuego
				+ ", precioJuegoJuego=" + precioJuegoJuego + ", precioAlquilerJuego=" + precioAlquilerJuego
				+ ", idMarca=" + idMarca + ", fechaLanzamientoJuego=" + fechaLanzamientoJuego + "]";
	}

}
