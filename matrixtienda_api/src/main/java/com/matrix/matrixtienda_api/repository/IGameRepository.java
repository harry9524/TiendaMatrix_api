package com.matrix.matrixtienda_api.repository;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

public interface IGameRepository {

	public GameDTO getGamexId(GameRequest request) throws Exception;
	public GameResponse createUpdateGame(GameRequest request) throws Exception;
	public List<MarcaDTO> getMarcas() throws Exception;
	public List<RolDTO> getRoles() throws Exception;
	public List<GameDTO> getGames() throws Exception;
	public List<PlataformaDTO> getPlataformas() throws Exception;
	
}
