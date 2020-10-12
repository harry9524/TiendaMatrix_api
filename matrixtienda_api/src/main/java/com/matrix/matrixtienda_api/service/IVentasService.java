package com.matrix.matrixtienda_api.service;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;

public interface IVentasService {

	//Ventas
	public List<AlquilarJuegoDTO> getAlquileres() throws Exception;
	public List<AlquilarJuegoDTO> getAlquileresxFiltro(AlquilarJuegoRequest request) throws Exception;
	public AlquilarJuegoResponse createUpdateAlquiler(AlquilarJuegoRequest request) throws Exception;
	public AlquilarJuegoDTO getValueAlquiler(AlquilarJuegoRequest request) throws Exception;
	
}
