package com.matrix.matrixtienda_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.MarcaRequest;
import com.matrix.matrixtienda_api.modelo.MarcaResponse;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;
import com.matrix.matrixtienda_api.repository.IGameRepository;

@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameRepository gameRepository;
	
	@Override
	public GameDTO getGamexId(GameRequest request) throws Exception {
		return gameRepository.getGamexId(request);
	}

	@Override
	public GameResponse createUpdateGame(GameRequest request) throws Exception {
		return gameRepository.createUpdateGame(request);
	}

	@Override
	public MarcaResponse createUpdateMarca(MarcaRequest request) throws Exception {
		return gameRepository.createUpdateMarca(request);
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
	
}
