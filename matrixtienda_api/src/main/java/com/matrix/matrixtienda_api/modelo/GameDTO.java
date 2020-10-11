package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class GameDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public GameDTO() {
		
	}
	
	public GameDTO(Integer idJuego, String nombre, String descripcion, Integer precioJuego, Integer precioAlquiler,
			Integer idMarca, Date fechaLanzamiento) {
		this.idJuego = idJuego;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioJuego = precioJuego;
		this.precioAlquiler = precioAlquiler;
		this.idMarca = idMarca;
		this.fechaLanzamiento = fechaLanzamiento;
	}

	private Integer idJuego;
	private String nombre;
	private String descripcion;
	private Integer precioJuego;
	private Integer precioAlquiler;
	private Integer idMarca;
	private Date fechaLanzamiento;

	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecioJuego() {
		return precioJuego;
	}

	public void setPrecioJuego(Integer precioJuego) {
		this.precioJuego = precioJuego;
	}

	public Integer getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(Integer precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	@Override
	public String toString() {
		return "GameDTO [idJuego=" + idJuego + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioJuego="
				+ precioJuego + ", precioAlquiler=" + precioAlquiler + ", idMarca=" + idMarca + ", fechaLanzamiento="
				+ fechaLanzamiento + "]";
	}
	
}
