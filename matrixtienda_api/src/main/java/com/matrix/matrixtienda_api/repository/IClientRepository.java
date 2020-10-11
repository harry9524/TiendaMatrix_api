package com.matrix.matrixtienda_api.repository;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;

public interface IClientRepository {
	
	public ClientResponse registerClient (ClientRequest request);
	public ClientResponse getClientxDocumento (ClientRequest request);
	
}
