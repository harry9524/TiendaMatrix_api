package com.matrix.matrixtienda_api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
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
	public GameDTO getGamexId(GameRequest request) throws Exception {
		return gameRepository.getGamexId(request);
	}

	@Override
	public GameResponse createUpdateGame(GameRequest request) throws Exception {
		request.setFechaLanzamiento(new Date());		
		return gameRepository.createUpdateGame(request);
	}

	@Override
	public List<MarcaDTO> getMarcas() throws Exception {
		return gameRepository.getMarcas();
	}

	@Override
	public List<RolDTO> getRoles() throws Exception {
		return gameRepository.getRoles();
	}

	@Override
	public List<GameDTO> getGames() throws Exception {
		return gameRepository.getGames();
	}

	@Override
	public List<PlataformaDTO> getPlataformas() throws Exception {
		return gameRepository.getPlataformas();
	}
	
	@Override
	public List<ClientDTO> getClients() throws Exception {
		return clientRepository.getClients();
	}
	
	@Override
	public ClientResponse createUpdateClient(ClientRequest request) throws Exception{
		return clientRepository.createUpdateClient(request);
	}

	@Override
	public ClientDTO getClientxId(ClientRequest request) throws Exception{
		return clientRepository.getClientxId(request);
	}



}
