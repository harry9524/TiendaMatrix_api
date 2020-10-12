package com.matrix.matrixtienda_api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;
import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.FiltersAlquileresDTO;
import com.matrix.matrixtienda_api.modelo.FiltersJuegoDTO;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.repository.IClientRepository;
import com.matrix.matrixtienda_api.repository.IGameRepository;
import com.matrix.matrixtienda_api.repository.IVentaRepository;

@Service
public class VentasServiceImpl implements IVentasService {

	@Autowired
	IVentaRepository ventaRepository;
	
	@Autowired
	IGameRepository gameRepository;
	
	@Autowired
	IClientRepository clientRepository;
		
	@Override
	public List<AlquilarJuegoDTO> getAlquileresxFiltro(FiltersAlquileresDTO request) throws Exception {
		return ventaRepository.getAlquileresxFiltro(request);
	}
	
	@Override
	public AlquilarJuegoResponse createUpdateAlquiler(AlquilarJuegoRequest request) throws Exception {
		ClientRequest clientRequest = new ClientRequest();
		clientRequest.setDocumentoCliente(request.getDocumentoCliente());
		ClientDTO clientDetail = clientRepository.getClientxId(clientRequest);
		request.setIdCliente(clientDetail.getIdCliente());
		return ventaRepository.createUpdateAlquiler(request);
	}

	@Override
	public AlquilarJuegoDTO getValueAlquiler(AlquilarJuegoRequest request) throws Exception {
		Date fechaactual = new Date(System.currentTimeMillis());
		int milisecondsByDay = 86400000;
		System.err.println("Fecha Actual "+fechaactual);
		System.err.println("Fecha Fin "+request.getFechaFinPrestamo());
		int diasPrestamo = Math.abs((int) ((fechaactual.getTime()-request.getFechaFinPrestamo().getTime()) / milisecondsByDay));
		System.err.println("Dìas de Diferencia "+diasPrestamo);
		
		FiltersJuegoDTO requestGame = new FiltersJuegoDTO();
		requestGame.setIdJuego(request.getIdJuego());
		GameDTO gameSeleccionado = gameRepository.getGamexFilters(requestGame).get(0);
		
		int valorPagar = gameSeleccionado.getPrecioAlquilerJuego()*diasPrestamo;
		
		request.setValorPagado(valorPagar);
		return request;
	}
	
}
