package com.matrix.matrixtienda_api.repository;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GenericoResponse;

public interface IClientRepository {
	
	public ClientResponse createUpdateClient (ClientRequest request) throws Exception;
	public ClientDTO getClientxId (ClientRequest request) throws Exception;
	public List<ClientDTO> getClients() throws Exception;
	public GenericoResponse validteClient(String documentoCliente) throws Exception;
	
}
