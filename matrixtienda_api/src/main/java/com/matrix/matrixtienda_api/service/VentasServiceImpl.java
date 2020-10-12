package com.matrix.matrixtienda_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;
import com.matrix.matrixtienda_api.repository.IVentaRepository;

@Service
public class VentasServiceImpl implements IVentasService {

	@Autowired
	IVentaRepository ventaRepository;
	
	@Override
	public List<AlquilarJuegoDTO> getAlquileres() throws Exception {
		return ventaRepository.getAlquileres();
	}
	
	@Override
	public AlquilarJuegoResponse createUpdateAlquiler(AlquilarJuegoRequest request) throws Exception {
		return ventaRepository.createUpdateAlquiler(request);
	}
	
	

}
