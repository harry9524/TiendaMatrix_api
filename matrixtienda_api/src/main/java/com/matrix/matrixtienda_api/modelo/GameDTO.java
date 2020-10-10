package com.matrix.matrixtienda_api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JUEGOS")
public class GameDTO {
	
	public GameDTO(Integer idJuego, String nombre, String descripcion, Integer precioJuego, Integer precioAlquiler,
			Integer idMarca) {
		super();
		this.idJuego = idJuego;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioJuego = precioJuego;
		this.precioAlquiler = precioAlquiler;
		this.idMarca = idMarca;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_JUEGO", nullable = false)
	private Integer idJuego;
	
	@Column(name = "NOMBRE", nullable = false, unique = true)
	private String nombre;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column(name = "PRECIO_JUEGO", nullable = false)
	private Integer precioJuego;
	
	@Column(name = "PRECIO_ALQUILER", nullable = false)
	private Integer precioAlquiler;
	
	@Column(name = "ID_MARCA", nullable = false)
	private Integer idMarca;

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
	
	@Override
	public String toString() {
		return "GameDTO [idJuego=" + idJuego + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioJuego="
				+ precioJuego + ", precioAlquiler=" + precioAlquiler + ", idMarca=" + idMarca + "]";
	}
	
	
}
