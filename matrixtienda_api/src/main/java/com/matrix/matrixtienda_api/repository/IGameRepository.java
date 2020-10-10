package com.matrix.matrixtienda_api.repository;

import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;

public interface IGameRepository {

	public GameResponse getGame (GameRequest request);
	
}
