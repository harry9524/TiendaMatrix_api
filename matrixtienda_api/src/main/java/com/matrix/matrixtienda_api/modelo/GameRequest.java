package com.matrix.matrixtienda_api.modelo;

import java.util.Date;

public class GameRequest extends GameDTO{

	public GameRequest(Integer idJuego, String nombre, String descripcion, Integer precioJuego, Integer precioAlquiler,
			Integer idMarca, Date fechaLanzamiento) {
		super(idJuego, nombre, descripcion, precioJuego, precioAlquiler, idMarca, fechaLanzamiento);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
