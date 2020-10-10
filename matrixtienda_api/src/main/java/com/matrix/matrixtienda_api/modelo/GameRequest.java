package com.matrix.matrixtienda_api.modelo;

public class GameRequest extends GameDTO{

	public GameRequest(Integer idJuego, String nombre, String descripcion, Integer precioJuego, Integer precioAlquiler,
			Integer idMarca) {
		super(idJuego, nombre, descripcion, precioJuego, precioAlquiler, idMarca);
	}

}
