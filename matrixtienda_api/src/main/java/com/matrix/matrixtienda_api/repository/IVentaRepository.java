package com.matrix.matrixtienda_api.repository;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;

public interface IVentaRepository {

	public List<AlquilarJuegoDTO> getAlquileres() throws Exception;
	public AlquilarJuegoResponse createUpdateAlquiler (AlquilarJuegoRequest request) throws Exception;
	
}
