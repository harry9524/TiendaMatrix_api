package com.matrix.matrixtienda_api.repository;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;
import com.matrix.matrixtienda_api.modelo.FiltersAlquileresDTO;

public interface IVentaRepository {

	public AlquilarJuegoResponse createUpdateAlquiler (AlquilarJuegoRequest request) throws Exception;
	public Integer getClientFrecuentyer() throws Exception;
	public Integer getGameTop() throws Exception;
	public List<AlquilarJuegoDTO> getAlquileresxFiltro(FiltersAlquileresDTO request) throws Exception;
	
	
}
