package com.matrix.matrixtienda_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.repository.IClientRepository;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	IClientRepository clientRepository;
	
	@Override
	public List<ClientDTO> getClients() throws Exception {
		return clientRepository.getClients();
	}
	
	@Override
	public ClientResponse createUpdateClient(ClientRequest request) throws Exception{
		return clientRepository.createUpdateClient(request);
	}

	@Override
	public ClientDTO getClientxId(ClientRequest request) throws Exception{
		return clientRepository.getClientxId(request);
	}
	
}
