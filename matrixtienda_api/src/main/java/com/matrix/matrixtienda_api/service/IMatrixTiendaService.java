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

	public GameResponse getGamexId (GameRequest request);
	public GameResponse registerGame (GameRequest request);
	public List<MarcaDTO> getMarcas();
	public List<RolDTO> getRoles();
	public List<GameDTO> getGames();
	public List<PlataformaDTO> getPlataformas();
	
	public ClientResponse registerClient (ClientRequest request);
	public ClientResponse getClientxDocumento (ClientRequest request);
	
	
}
