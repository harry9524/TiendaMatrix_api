package com.matrix.matrixtienda_api.service;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;

public interface IMatrixTiendaService {

	public GameResponse getGame (GameRequest request);
	public GameResponse registerGame (GameRequest request);
	public ClientResponse registerClient (ClientRequest request);
	
	
	
}
