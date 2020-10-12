package com.matrix.matrixtienda_api.service;

import java.util.ArrayList;
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
import com.matrix.matrixtienda_api.repository.IVentaRepository;

@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameRepository gameRepository;
	
	@Autowired
	IVentaRepository ventaRepository;
	
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
	public List<GameDTO> getGameTop() throws Exception {
		
		//Se consulta y obtien el id_cliente del cliente que mas transacciones tenga en la tabla de ALQUILER_JUEGOS
		GameRequest request = new GameRequest();
		request.setIdJuego(ventaRepository.getGameTop());
		
		//con este id_cliente usamos el metodo de getClientexId para obtener la información de dicho usuario
		List<GameDTO> gamesTop = new ArrayList<GameDTO>();
		GameDTO gameTop = gameRepository.getGamexId(request);
		gamesTop.add(gameTop);
		return gamesTop;
	}
	
	@Override
	public List<PlataformaDTO> getPlataformas() throws Exception {
		return gameRepository.getPlataformas();
	}

	@Override
	public List<PlataformaDTO> getPlataformasxGame(Integer idJuego) throws Exception {
		return gameRepository.getPlataformasxGame(idJuego);
	}
	
}
