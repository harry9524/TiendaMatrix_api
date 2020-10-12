package com.matrix.matrixtienda_api.service;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.FiltersJuegoDTO;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.MarcaRequest;
import com.matrix.matrixtienda_api.modelo.MarcaResponse;
import com.matrix.matrixtienda_api.modelo.PersonaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

public interface IGameService {

	//Juegos
	public List<PlataformaDTO> getPlataformas() throws Exception;
	public List<MarcaDTO> getMarcas() throws Exception;
	public List<RolDTO> getRoles() throws Exception;
	public List<PersonaDTO> getPersonas() throws Exception;
	public List<GameDTO> getGames() throws Exception;	
	public List<GameDTO> getGamexFilters(FiltersJuegoDTO request)  throws Exception;
	public List<GameDTO> getGameTop() throws Exception;
	public GameDTO getGamexId (GameRequest request) throws Exception;
	public List<PlataformaDTO> getPlataformasxGame(Integer idJuego) throws Exception;
	public GameResponse createUpdateGame (GameRequest request) throws Exception;
	public MarcaResponse createUpdateMarca (MarcaRequest request) throws Exception;

}
