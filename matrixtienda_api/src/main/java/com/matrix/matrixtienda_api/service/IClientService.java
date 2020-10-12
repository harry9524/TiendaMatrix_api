package com.matrix.matrixtienda_api.service;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GenericoResponse;

public interface IClientService {

	//Clientes
	public List<ClientDTO> getClients() throws Exception;	
	public List<ClientDTO> getClientFrecuentyer() throws Exception;
	public ClientDTO getClientxId (ClientRequest request) throws Exception;	
	public ClientResponse createUpdateClient (ClientRequest request) throws Exception;
	public GenericoResponse validteClient(String documentoCliente) throws Exception;
	
}
