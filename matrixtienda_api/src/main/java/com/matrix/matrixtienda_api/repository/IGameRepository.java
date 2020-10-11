package com.matrix.matrixtienda_api.repository;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

public interface IGameRepository {

	public GameResponse getGamexId(GameRequest request);
	public List<MarcaDTO> getMarcas();
	public List<RolDTO> getRoles();
	public List<GameDTO> getGames();
	public List<PlataformaDTO> getPlataformas();
	
}
