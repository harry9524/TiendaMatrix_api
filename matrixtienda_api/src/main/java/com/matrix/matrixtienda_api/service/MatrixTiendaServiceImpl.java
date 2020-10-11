package com.matrix.matrixtienda_api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;
import com.matrix.matrixtienda_api.repository.IClientRepository;
import com.matrix.matrixtienda_api.repository.IGameRepository;

@Service
public class MatrixTiendaServiceImpl implements IMatrixTiendaService {

	@Autowired
	IGameRepository gameRepository;
	
	@Autowired
	IClientRepository clientRepository;
	
	@Override
	public GameResponse getGamexId(GameRequest request) {
		if(request.getIdJuego()== null || request.getIdJuego()==0) {
			GameResponse response = new GameResponse();
			response.setExitoso(false);
			response.setMensajeError("Debe ingresar un criterio de busqueda");
			return response;
		}else {
			return gameRepository.getGamexId(request);
		}
		
	}

	@Override
	public GameResponse registerGame(GameRequest request) {
		GameResponse reponse = new GameResponse();
		request.setFechaLanzamiento(new Date());
		
		reponse.setExitoso(true);
		reponse.setMensajeError(null);
		return reponse;
	}

	@Override
	public ClientResponse registerClient(ClientRequest request) {
		return clientRepository.registerClient(request);
	}

	@Override
	public ClientResponse getClientxDocumento(ClientRequest request) {
		return clientRepository.getClientxDocumento(request);
	}
	
	@Override
	public List<MarcaDTO> getMarcas() {
		return gameRepository.getMarcas();
	}

	@Override
	public List<RolDTO> getRoles() {
		return gameRepository.getRoles();
	}

	@Override
	public List<GameDTO> getGames() {
		return gameRepository.getGames();
	}
	
	@Override
	public List<PlataformaDTO> getPlataformas() {
		return gameRepository.getPlataformas();
	}
	
}
