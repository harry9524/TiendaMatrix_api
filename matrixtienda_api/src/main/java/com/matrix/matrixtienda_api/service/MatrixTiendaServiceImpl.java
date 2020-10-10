package com.matrix.matrixtienda_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.repository.IGameRepository;
import com.matrix.matrixtienda_api.repository.IGameRepositoryJPA;

@Service
public class MatrixTiendaServiceImpl implements IMatrixTiendaService {

	@Autowired
	IGameRepository gameRepository;
	
	@Autowired
	IGameRepositoryJPA gameRepositoryJpa;
	
	@Override
	public GameResponse getGame(GameRequest request) {
		if(request.getIdJuego()== null || request.getIdJuego()==0) {
			GameResponse response = new GameResponse();
			response.setExitoso(false);
			response.setMensajeError("Debe ingresar un criterio de busqueda");
			return response;
		}else {
			return gameRepository.getGame(request);
		}
		
	}

	@Override
	public GameResponse registerGame(GameRequest request) {
		GameResponse reponse = new GameResponse();
		gameRepositoryJpa.save(request);
		
		reponse.setExitoso(true);
		reponse.setMensajeError(null);
		return reponse;
	}

	@Override
	public ClientResponse registerClient(ClientRequest request) {
		return null;
	}


}
