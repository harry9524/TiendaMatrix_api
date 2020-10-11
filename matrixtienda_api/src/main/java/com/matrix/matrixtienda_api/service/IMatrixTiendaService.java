package com.matrix.matrixtienda_api.service;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

public interface IMatrixTiendaService {

	public GameDTO getGamexId (GameRequest request) throws Exception;
	public GameResponse createUpdateGame (GameRequest request) throws Exception;
	public List<MarcaDTO> getMarcas() throws Exception;
	public List<RolDTO> getRoles() throws Exception;
	public List<GameDTO> getGames() throws Exception;
	public List<PlataformaDTO> getPlataformas() throws Exception;
	
	public ClientResponse registerClient (ClientRequest request) throws Exception;
	public ClientResponse getClientxDocumento (ClientRequest request) throws Exception;
	
	
}
